package datadumper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class DataType {
    protected long loadAddress;
    protected DataDumper dumper;
    protected DataDumperInputFile inputFile;
    protected String label;
    protected FormatType format;
    protected DataType related;
    protected SystemType systemType;
    protected int size;
    
    public static final NullDataType nullDataType = new NullDataType(null, null);

    public DataType(DataDumper dumper, FormatType format) {
        this(dumper, format, DataType.nullDataType);
    }

    public DataType(DataDumper dumper, FormatType format, DataType related) {
        this.dumper = dumper;
        this.format = format;
        this.related = related;
        this.label = "";
        if (this.dumper != null) {
        	this.inputFile = this.dumper.getInputFile();
        	this.systemType = this.dumper.getSystemType();
        }
    	this.size = -1;
    }

    public void parse() {
        this.setAddressFromInputFilePos();
        try {
			this.dumper.getLogFile().write(String.format("Parsing %s at %x\n", this.getClass().getName(), this.getLoadAddress()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        this.parseData();
    }
    
    public void setAddressFromInputFilePos() {
        this.loadAddress = inputFile.getFilePointer();    		
        this.dumper.addParsedAddress(this.loadAddress);
    }

    public abstract void parseData();

    public long getLoadAddress() {
        return this.loadAddress;
    }

    public long getVirtualAddress() {
    	return this.fileOffsetToAddress(this.loadAddress);
    }

    // lazy way of creating a new datatype object for datatypes with no additional args
    public DataType createCopy() {
    	try {
    		return this.getClass().getConstructor(DataDumper.class, FormatType.class, DataType.class).newInstance(this.dumper, this.format, this.related.createCopy());
		} catch (NoSuchMethodException e1) {
			try {
				return this.getClass().getConstructor(DataDumper.class, FormatType.class).newInstance(this.dumper, this.format);
			} catch (NoSuchMethodException e1_1) {
				throw new RuntimeException(
					String.format("Neither constructor (DataDumper, FormatType, DataType) or" +
								  "(DataDumper, FormatType) does not exist! (Try overriding %s::createCopy)", this.getClass().getName()), e1_1);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e1_2) {
				throw new RuntimeException(e1_2);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
			throw new RuntimeException(e2);
		}
    }

    public String toString() {
        // first print any labels at this address
    	try {
			this.dumper.getLogFile().write(String.format("%s at %x\n", this.getClass().getName(), this.getLoadAddress()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
        String output = "";
        if (this.format != FormatType.NONE) {
        	boolean labelAtAddress = false;
        	ArrayList<DataTypeAddressPair> parsedDataTypes = this.dumper.getDataTypesToParse();
        	for (DataTypeAddressPair dataTypeAddressPair : parsedDataTypes) {
        		DataType dataType = dataTypeAddressPair.dataType;
        		if (dataType.getLoadAddress() == this.loadAddress && !dataType.getLabel().equals("")) {
        			labelAtAddress = true;
        			output += "\n\n" + dataType.getLabel() + ":" /* + this.getClass().getName() + "::" + this.format*/;
        		}
        	}
        
        	if (this.format == FormatType.BLOCK) {
        		if (!this.getBlockFormatPrefix().equals("")) {
        			output += "\n\t" + this.getBlockFormatPrefix() + " ";
        		}
        	} else if (this.format == FormatType.INLINE) {
        		if (labelAtAddress) {
        			throw new UnsupportedOperationException("Attempting to print inline data type after label!");
        		}
        		output += ", ";
        	} else {
        		throw new UnsupportedOperationException("Attempting to print unsupported FormatType of " + this.format);
        	}
        }
        output += this.getDatatypeAsStr();
        return output;
    }

    public abstract String getDatatypeAsStr();

    public abstract String getBlockFormatPrefix();

    public long fileOffsetToAddress(long address) {
    	return this.getSystemType().fileOffsetToAddress(address);
    }

    public long addressToFileOffset(long address) {
    	return this.getSystemType().addressToFileOffset(address);
    }

    // Override this method maybe
    public int getSize() {
    	if (this.size == -1) {
        	throw new UnsupportedOperationException(String.format("%s does not have a known size!", this.getClass().getName()));
    	}
		return this.size;
    }

    public SystemType getSystemType() {
    	return this.systemType;
    }

    public long readFromSize() {
    	return this.readFromSizeArg(this.getSize());
    }

    public long readFromSizeArg(int size) {
    	long value = readFromSizeIgnoreEndianness(size);
    	if (this.getSystemType().getDefaultEndianness() == Endianness.BIG) {
    		return value;
    	} else {
    		return DataDumper.swapX(value, size);
    	}
    }

    private long readFromSizeIgnoreEndianness(int size) {
    	if (size == 1) {
    		return this.inputFile.read();
    	} else if (size == 2) {
			return this.inputFile.readUnsignedShort();
    	} else if (size == 3) {
    		return (this.inputFile.read() << 16) | (this.inputFile.read() << 8) | this.inputFile.read();
    	} else if (size == 4) {
    		return this.inputFile.readInt();
    	} else {
    		throw new UnsupportedOperationException("No support currently for reading a size of " + size + "!");
    	}
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
