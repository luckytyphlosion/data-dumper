package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.ValueType;

public abstract class PrimitiveDT extends DataType {

    protected long value;
    protected String varId;

    public PrimitiveDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
        this.varId = "";
    }

    public PrimitiveDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format);
        this.varId = varId;
    }

    @Override
    public DataType createCopy() {
        return DataType.createCopyWithArgs(this,
                new Class[] {DataDumper.class, FormatType.class, String.class},
                new Object[] {this.dumper, this.format, this.varId});
    }

    @Override
    public void parseData() {
        this.value = this.readFromSize();
        if (!this.varId.equals("")) {
            this.dumper.addVariable(this.varId, this.getValueType());
        }
    }

    public abstract String getDatatypeAsStr();

    public long getValue() {
        return this.value;
    }

    public abstract ValueType getValueType();

    public int getValueAsInt() {
        return Math.toIntExact(value);
    }

    @Override
    public String getBlockFormatPrefix() {
        return this.getSystemType().getPrefixFromSize(this.getSize());
    }

    // Override this method maybe
    public abstract int getSize();
    /*        if (this.size == -1) {
            throw new UnsupportedOperationException(String.format("%s does not have a known size!", this.getClass().getName()));
        }
        return this.size;*/

    public long readFromSize() {
        return this.readFromSizeArg(this.getSize());
    }
}
