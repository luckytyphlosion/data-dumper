package datadumper;

public class GBAByteDT extends DataType {

	protected int value;

	public GBAByteDT(DataDumper dumper, FormatType format) {
		super(dumper, format);
		// TODO Auto-generated constructor stub
	}

	public GBAByteDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseData() {
		this.value = this.inputFile.read();
	}

	@Override
	public String getDatatypeAsStr() {
		return String.format("0x%02x", this.value);
	}

	@Override
	public String getBlockFormatPrefix() {
		return ".byte";
	}

}
