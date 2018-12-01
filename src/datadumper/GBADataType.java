package datadumper;

public abstract class GBADataType extends DataType {

	public static final long GBA_VMA_OFFSET = 0x8000000L;

	public GBADataType(DataDumper dumper, FormatType format) {
		super(dumper, format);
		// TODO Auto-generated constructor stub
	}

	public GBADataType(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long fileOffsetToAddress(long address) {
		return Math.addExact(address, GBADataType.GBA_VMA_OFFSET);
	}

	@Override
	public long addressToFileOffset(long address) {
		return Math.subtractExact(address, GBADataType.GBA_VMA_OFFSET);
	}
	
	/*public int compareTo(Address comparedAddress) {
        long delta = this.address - comparedAddress.getAddress();
        if (delta > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (delta < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)delta;
        }
    }*/

}
