package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class PrimitiveDT extends DataType {

    protected long value;

    public PrimitiveDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public PrimitiveDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        this.value = this.readFromSize();
    }

    public abstract String getDatatypeAsStr();

    public long getValue() {
        return this.value;
    }
    
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
