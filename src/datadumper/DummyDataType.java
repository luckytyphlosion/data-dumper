package datadumper;

public class DummyDataType extends DataType {

    public DummyDataType(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public void parseData() {

    }

    @Override
    public String getDatatypeAsStr() {
        return "";
    }

    @Override
    public String getBlockFormatPrefix() {
        // TODO Auto-generated method stub
        return "";
    }

}
