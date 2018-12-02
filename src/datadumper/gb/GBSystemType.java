package datadumper.gb;

import datadumper.Endianness;
import datadumper.SystemType;

public class GBSystemType extends SystemType {

	@Override
	public String getPrefixFromSize(int size) {
		if (size == 1) {
			return "db";
		} else if (size == 2) {
			return "dw";
		} else {
			throw new IllegalArgumentException("Invalid GBSystemType size of " + size + "!");
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
	
	@Override
	public String getHexPrefix() {
		return "$";
	}

	@Override
	public String getBinaryPrefix() {
		return "%";
	}
	
	@Override
	public Endianness getDefaultEndianness() {
		return Endianness.LITTLE;
	}
}
