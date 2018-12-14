package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class HexByteDT extends RawPrimitiveDT {

    public HexByteDT(DataDumper dumper, FormatType format) {
        super(dumper, format, "1%02x");
    }

    public DataType createCopy() {
        return new HexByteDT(this.dumper, this.format);
    }
}
