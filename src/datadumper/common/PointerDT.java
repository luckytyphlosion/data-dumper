package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class PointerDT extends DataType {

    protected long pointerAddress;
    // protected String pointerLabel;
    // protected String parentBase;

    public PointerDT(DataDumper dumper, FormatType format, /*String pointerLabel, String parentBase,*/ DataType related) {
        super(dumper, format, related);
        // this.pointerLabel = pointerLabel;
        // this.parentBase = parentBase;
    }

    /*@Override
    public DataType createCopy() {
        return DataType.createCopyWithArgs(this,
            new Class[] {DataDumper.class, FormatType.class, String.class, String.class, DataType.class},
            new Object[] {this.dumper, this.format, this.label, this.parentBase, this.related.createCopy()});
    }*/

    @Override
    public void parseData() {
        this.pointerAddress = this.readPointer();
        this.dumper.addDataTypeToParse(this.related, this.pointerAddress, this.getDatatypeAsStr());
    }

    public abstract long readPointer();
}
