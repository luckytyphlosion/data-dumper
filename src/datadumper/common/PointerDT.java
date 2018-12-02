package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class PointerDT extends DataType {

    protected long pointerAddress;

    public PointerDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public PointerDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        this.pointerAddress = this.readPointer();
        this.dumper.addDataTypeToParse(this.related, this.pointerAddress, this.getDatatypeAsStr());
    }

    public abstract long readPointer();
}
