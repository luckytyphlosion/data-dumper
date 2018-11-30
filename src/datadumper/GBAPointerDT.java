package datadumper;

public class GBAPointerDT extends PointerDT {
	
	public static final long GBA_VMA_OFFSET = 0x8000000L;

	public GBAPointerDT(DataDumper dumper, FormatType format) {
		super(dumper, format);
	}

	public GBAPointerDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
	}

	@Override
	public Address readPointer() {
		long tempAddress = DataDumper.swapInteger(this.inputFile.readInt()) & 0xFFFFFFFF;
		return new GBAAddress(tempAddress);
	}

	@Override
	public String getDatatypeAsStr() {
		return String.format("unk_%08x", this.pointerAddress.getAddress());
	}

	@Override
	public String getBlockFormatPrefix() {
		return ".word";
	}

}
