package datadumper;

public abstract class ListDT extends GenericDataType {

	public ListDT(DataDumper dumper, FormatType format) {
		super(dumper, format);
		// TODO Auto-generated constructor stub
	}

	public ListDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseData() {
		// TODO Auto-generated method stub

	}

	public abstract boolean loopCondition();

	@Override
	public String getDatatypeAsStr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBlockFormatPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

}
