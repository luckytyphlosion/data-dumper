package datadumper;

public abstract class SystemType {
	
	public SystemType() {
		super();
	}
	
	public abstract String getPrefixFromSize(int size);

    public abstract long fileOffsetToAddress(long address);

    public abstract long addressToFileOffset(long address);
    
    public abstract String getHexPrefix();
    
    public abstract String getBinaryPrefix();
    
    public abstract Endianness getDefaultEndianness();
}
