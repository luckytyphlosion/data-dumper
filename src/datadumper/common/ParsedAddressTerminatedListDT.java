package datadumper.common;

import java.util.ArrayList;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.DataTypeAddressPair;
import datadumper.FormatType;

// very bad heuristic list
// parses until the address it currently is on has been added previously

public class ParsedAddressTerminatedListDT extends ListDT {

    protected long stopAddress;

    public ParsedAddressTerminatedListDT(DataDumper dumper, FormatType format, DataType related) {
        this(dumper, format, -1, related);
    }

    public ParsedAddressTerminatedListDT(DataDumper dumper, FormatType format, long stopAddress, DataType related) {
        super(dumper, format, related);
        this.stopAddress = stopAddress;
    }

    public DataType createCopy() {
        return new ParsedAddressTerminatedListDT(this.dumper, this.format, this.stopAddress, this.related);
    }

    @Override
    public boolean loopCondition() {
        ArrayList<DataTypeAddressPair> dataTypesToParse = this.dumper.getDataTypesToParse();
        long loadAddress = this.inputFile.getFilePointer();
        if (this.stopAddress != -1 && this.stopAddress <= loadAddress) {
            return false;
        }
        for (DataTypeAddressPair dataTypeAddressPair : dataTypesToParse) {
            // using direct comparison to test if it's the exact same object
            if (dataTypeAddressPair.address == loadAddress && dataTypeAddressPair.dataType != this) {
                return false;
            }
        }
        return true;
    }
}
