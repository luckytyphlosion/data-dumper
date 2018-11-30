package datadumper;

public class GBAAddress extends Address {
	
	public static final long GBA_VMA_OFFSET = 0x8000000L;

	public GBAAddress(long address) {
		super(address);
	}

	@Override
	public long fileOffsetToAddress(long address) {
		return Math.addExact(address, GBAAddress.GBA_VMA_OFFSET);
	}

	@Override
	public long addressToFileOffset(long address) {
		return Math.subtractExact(address, GBAAddress.GBA_VMA_OFFSET);
	}
	
    public int compareTo(Address comparedAddress) {
        long delta = this.address - comparedAddress.getAddress();
        if (delta > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (delta < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)delta;
        }
    }

}
