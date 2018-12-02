package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.PrimitiveDT;

public class RawPrimitiveDT extends PrimitiveDT {

    protected RadixType radix;
    protected boolean padding;

    public RawPrimitiveDT(DataDumper dumper, FormatType format, int size, RadixType radix) {
        this(dumper, format, size, false, radix);
    }

    public RawPrimitiveDT(DataDumper dumper, FormatType format, int size, boolean padding, RadixType radix) {
        super(dumper, format);
        this.size = size;
        this.padding = padding;
        this.radix = radix;
    }

    public DataType createCopy() {
        return new RawPrimitiveDT(this.dumper, this.format, this.size, this.padding, this.radix);
    }

    @Override
    public String getDatatypeAsStr() {
        switch (this.radix) {
        case DECIMAL:
            return Long.toString(this.value);
        case HEXIDECIMAL:
            if (this.padding) {
                return String.format("%s%0" + this.getSize() * 2 + "x", this.getSystemType().getHexPrefix(), this.value);
            } else {
                return String.format("%s%x", this.getSystemType().getHexPrefix(), this.value);
            }
        case BINARY:
            if (this.padding) {
                return String.format("%s%" + + this.getSize() * 2 + "b", this.getSystemType().getBinaryPrefix(), this.value);				
            } else {
                return String.format("%s%b", this.getSystemType().getBinaryPrefix(), this.value);
            }
        default:
            throw new RuntimeException("Tried to convert RawPrimitiveDT of unknown radix " + this.radix + "!");
        }
    }
}
