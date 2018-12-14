package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class FormatDT extends DataType {

    protected String formatStr;

    public FormatDT(DataDumper dumper, FormatType format, String formatStr) {
        super(dumper, format);
        this.formatStr = formatStr;
    }

    public DataType createCopy() {
        return new FormatDT(this.dumper, this.format, this.formatStr);
    }

    @Override
    public void parseData() {
        // does not actually parse data
    }

    @Override
    public String getDatatypeAsStr() {
        return formatStr;
    }

    @Override
    public String getBlockFormatPrefix() {
        return "";
    }

}
