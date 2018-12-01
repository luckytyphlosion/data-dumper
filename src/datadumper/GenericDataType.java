package datadumper;

public abstract class GenericDataType extends DataType {

	public GenericDataType(DataDumper dumper, FormatType format) {
		super(dumper, format);
		// TODO Auto-generated constructor stub
	}

	public GenericDataType(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long fileOffsetToAddress(long address) {
		return this.related.fileOffsetToAddress(address);
	}

	@Override
	public long addressToFileOffset(long address) {
		return this.related.addressToFileOffset(address);
	}

}
