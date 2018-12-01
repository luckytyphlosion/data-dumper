package datadumper;

public abstract class GBDataType extends DataType {

	public GBDataType(DataDumper dumper, FormatType format) {
		super(dumper, format);
	}

	public GBDataType(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
	}

	@Override
	public long fileOffsetToAddress(long address) {
		return address;
	}

	@Override
	public long addressToFileOffset(long address) {
		return address;
	}

}
