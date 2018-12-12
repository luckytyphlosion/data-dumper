package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class UnionDT extends DataType {

    protected DataType chosenDataType;

    public UnionDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public UnionDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        this.chosenDataType = this.getChosenDataType();
        this.chosenDataType.parse();
    }

    public abstract DataType getChosenDataType();

    @Override
    public String getDatatypeAsStr() {
        return this.beforeDatatypeAsStr() + this.chosenDataType.toString();
    }

    public String beforeDatatypeAsStr() {
        return "";
    }

    @Override
    public String getBlockFormatPrefix() {
        return "";
    }

}
