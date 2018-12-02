package datadumper;

public class NullDataType extends DataType {

    public NullDataType(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public NullDataType(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        throw new UnsupportedOperationException("Cannot parse a NullDataType!");
    }

    public DataType createCopy() {
        return this;
    }

    @Override
    public String getDatatypeAsStr() {
        throw new UnsupportedOperationException("Cannot convert a NullDataType to String!");
    }

    @Override
    public String getBlockFormatPrefix() {
        throw new UnsupportedOperationException("NullDataType does not have a block format prefix!");
    }

}
