package datadumper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class DataType {
    protected Address address;
    protected DataDumper dumper;
    protected DataDumperInputFile inputFile;
    protected String label;
    protected FormatType format;
    protected DataType related;

    public DataType(DataDumper dumper, FormatType format) {
        this(dumper, format, null);
    }

    public DataType(DataDumper dumper, FormatType format, DataType related) {
        this.dumper = dumper;
        this.format = format;
        this.related = related;
        this.label = "";
        this.inputFile = this.dumper.getInputFile();
    }
    
    public void parse() {
        this.setAddressFromInputFilePos();
        this.parseData();
    }
    
    public void setAddressFromInputFilePos() {
    	// GBAAddress temporary
        this.address = new GBAAddress(inputFile.getFilePointer());    		
        this.dumper.addParsedAddress(this.address);
    }

    public abstract void parseData();
    
    public Address getAddress() {
        return this.address;
    }

    // lazy way of creating a new datatype object for datatypes with no additional args
    public DataType createCopy() {
    	try {
    		return this.getClass().getConstructor(DataDumper.class, FormatType.class, DataType.class).newInstance(this.dumper, this.format, this.related);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("Could not copy DataType " + this.getClass() + "! (check if the basic constructor \"DataDumper, FormatType, DataType\" exists, otherwise override this method)", e);
		}
    }

    public String toString() {
        // first print any labels at this address
        boolean labelAtAddress = false;
        String output = "";
        ArrayList<DataTypeAddressPair> parsedDataTypes = this.dumper.getDataTypesToParse();
        for (DataTypeAddressPair dataTypeAddressPair : parsedDataTypes) {
        	DataType dataType = dataTypeAddressPair.dataType;
            if (dataType.getAddress().compareTo(this.address) == 0 && !dataType.getLabel().equals("")) {
                labelAtAddress = true;
                output += "\n" + dataType.getLabel();
            }
        }
        // not sure if this is needed
        /*if (labelAtAddress) {
            output += "\n";
        }*/
        
        if (this.format == FormatType.BLOCK) {
            output += "\n\t" + this.getBlockFormatPrefix() + " ";
        } else if (this.format == FormatType.INLINE) {
            if (labelAtAddress) {
                throw new UnsupportedOperationException("Attempting to print inline data type after label!");
            }
            output += ", ";
        } else {
            throw new UnsupportedOperationException("Attempting to print unsupported FormatType of " + this.format);
        }
        
        output += this.getDatatypeAsStr();
        return output;
    }

    public abstract String getDatatypeAsStr();

    public abstract String getBlockFormatPrefix();

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
