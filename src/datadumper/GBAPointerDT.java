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
	public long readPointer() {
		return (DataDumper.swapInteger(this.inputFile.readInt()) - GBAPointerDT.GBA_VMA_OFFSET) & 0xFFFFFFFF;
	}

	@Override
	public String getDatatypeAsStr() {
		return String.format("unk_%08x", this.pointerAddress);
	}

	@Override
	public String getBlockFormatPrefix() {
		return ".word";
	}

}
