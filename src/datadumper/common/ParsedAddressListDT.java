package datadumper.common;

import java.util.ArrayList;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.QueuedDataType;
import datadumper.FormatType;

// very bad heuristic list
// parses until the address it currently is on has been added previously

public class ParsedAddressListDT extends ListDT {

    protected long stopAddress;

    public ParsedAddressListDT(DataDumper dumper, FormatType format, DataType related) {
        this(dumper, format, -1, related);
    }

    public ParsedAddressListDT(DataDumper dumper, FormatType format, long stopAddress, DataType related) {
        super(dumper, format, related);
        this.stopAddress = stopAddress;
    }

    public DataType createCopy() {
        return new ParsedAddressListDT(this.dumper, this.format, this.stopAddress, this.related);
    }

    @Override
    public boolean loopCondition() {
        ArrayList<QueuedDataType> dataTypeQueue = this.dumper.getDataTypeQueue();
        long loadAddress = this.inputFile.getFilePointer();
        if (this.stopAddress != -1 && this.stopAddress <= loadAddress) {
            return false;
        }
        for (QueuedDataType queuedDataType : dataTypeQueue) {
            // using direct comparison to test if it's the exact same object
            if (queuedDataType.address == loadAddress && queuedDataType.dataType != this) {
                return false;
            }
        }
        return true;
    }
}
