package datadumper;

// todo class while I figure out what the f I need this class for
public class TempAddress extends Address {

	public TempAddress(long address) {
		super(address);
	}

	@Override
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

	@Override
	public long fileOffsetToAddress(long address) {
		return address;
	}

	@Override
	public long addressToFileOffset(long address) {
		return address;
	}
}
