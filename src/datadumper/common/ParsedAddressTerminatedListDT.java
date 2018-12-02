package datadumper.common;

import java.util.ArrayList;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.DataTypeAddressPair;
import datadumper.FormatType;

// very bad heuristic list
// parses until the address it currently is on has been added previously

public class ParsedAddressTerminatedListDT extends ListDT {

    public ParsedAddressTerminatedListDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public boolean loopCondition() {
        ArrayList<DataTypeAddressPair> dataTypesToParse = this.dumper.getDataTypesToParse();
        long loadAddress = this.inputFile.getFilePointer();
        for (DataTypeAddressPair dataTypeAddressPair : dataTypesToParse) {
            // using direct comparison to test if it's the exact same object
            if (dataTypeAddressPair.address == loadAddress && dataTypeAddressPair.dataType != this) {
                return false;
            }
        }
        return true;
    }
}
