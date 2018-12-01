
package datadumper;

import java.util.ArrayList;

public class DataDumper {
    private DataDumperInputFile inputFile;
    private ArrayList<DataTypeAddressPair> dataTypesToParse;
    private ArrayList<Long> parsedAddresses;
    
    public DataDumper(String name, String mode) {
		this.inputFile = new DataDumperInputFile(name, mode);
        this.dataTypesToParse = new ArrayList<DataTypeAddressPair>();
        this.parsedAddresses = new ArrayList<Long>();
    }

    public void addDataTypeToParse(DataType dataType, long address, String label) {
    	dataType.setLabel(label);
    	System.out.println(String.format("%x", address));
        this.dataTypesToParse.add(new DataTypeAddressPair(dataType, address));
    }
    
    public void addParsedAddress(long address) {
        this.parsedAddresses.add(address);
    }
    
    public DataDumperInputFile getInputFile() {
        return this.inputFile;
    }
    
    public ArrayList<DataTypeAddressPair> getDataTypesToParse() {
        return this.dataTypesToParse;
    }
    
    public ArrayList<Long> getParsedAddresses() {
        return this.parsedAddresses;
    }

    public void parse() {
    	// With a for each loop, a ConcurrentModificationException is thrown for each iteration if a new DataType is added.
    	// Since the only modification operation allowed is add, an indexed for-loop is used with size() as upper bound
    	// to account for new elements added
    	// ListIterator inserts the element in-between the current and next element, which is not wanted.
    	for (int i = 0; i < dataTypesToParse.size(); i++) {
    		DataTypeAddressPair dataTypeAddressPair = dataTypesToParse.get(i);
        	this.inputFile.seek(dataTypeAddressPair.address);
        	dataTypeAddressPair.dataType.parse();
            // TODO figure out cases of data indirection overlap e.g. in scripts
            // look ahead and don't parse on already parsed addresses?
            // dataType.setAddressFromInputFilePos();
            // dataType.parseData();
        }
    }

    public String generateOutput() {
        String output = "";
        for (DataTypeAddressPair dataTypeAddressPair : dataTypesToParse) {
            output += dataTypeAddressPair.dataType.toString();
        }
        return output;
    }
    
    /**
     * Converts a "short" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static short swapShort(final short value) {
        return (short) ( ( ( ( value >> 0 ) & 0xff ) << 8 ) +
            ( ( ( value >> 8 ) & 0xff ) << 0 ) );
    }

    /**
     * Converts a "int" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static int swapInteger(final int value) {
        return
            ( ( ( value >> 0 ) & 0xff ) << 24 ) +
            ( ( ( value >> 8 ) & 0xff ) << 16 ) +
            ( ( ( value >> 16 ) & 0xff ) << 8 ) +
            ( ( ( value >> 24 ) & 0xff ) << 0 );
    }

    /**
     * Converts a "long" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static long swapLong(final long value) {
        return
            ( ( ( value >> 0 ) & 0xff ) << 56 ) +
            ( ( ( value >> 8 ) & 0xff ) << 48 ) +
            ( ( ( value >> 16 ) & 0xff ) << 40 ) +
            ( ( ( value >> 24 ) & 0xff ) << 32 ) +
            ( ( ( value >> 32 ) & 0xff ) << 24 ) +
            ( ( ( value >> 40 ) & 0xff ) << 16 ) +
            ( ( ( value >> 48 ) & 0xff ) << 8 ) +
            ( ( ( value >> 56 ) & 0xff ) << 0 );
    }
}
