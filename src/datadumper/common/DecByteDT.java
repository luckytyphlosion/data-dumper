package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.RawPrimitiveDT;

public class DecByteDT extends RawPrimitiveDT {

    public DecByteDT(DataDumper dumper, FormatType format) {
        super(dumper, format, 1, RadixType.DECIMAL);
    }

    public DecByteDT(DataDumper dumper, FormatType format, boolean padding) {
        super(dumper, format, 1, padding, RadixType.DECIMAL);
    }
    
    public DataType createCopy() {
        return new DecByteDT(this.dumper, this.format, this.padding);
    }

}
