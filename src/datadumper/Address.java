package datadumper;

public abstract class Address implements Comparable<Address> {
// is this as bad as BlockPos?

    protected long address;

    public Address(long address) {
        this.address = address;
    }

    public long getFileOffset() {
        return addressToFileOffset(this.address);
    }

    public long getAddress() {
        return this.address;
    }

    public void setFileOffset(long fileOffset) {
        this.address = fileOffsetToAddress(fileOffset);
    }

    public void setAddress(long address) {
        this.address = address;
    }

    public abstract long fileOffsetToAddress(long address);

    public abstract long addressToFileOffset(long address);
}