package datadumper;

public abstract class GenericDataType extends DataType {

    public GenericDataType(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public GenericDataType(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public SystemType getSystemType() {
        return this.related.getSystemType();
    }

}
