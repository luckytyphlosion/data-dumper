package datadumper.gba;

import datadumper.Endianness;
import datadumper.SystemType;

public class GBASystemType extends SystemType {

    protected int flavour;

    public static final int FLAVOUR_0 = 0;
    public static final int FLAVOUR_1 = 1;
    public static final long GBA_VMA_OFFSET = 0x8000000L;

    public GBASystemType() {
        this.flavour = GBASystemType.FLAVOUR_0;
    }

    public GBASystemType(int flavour) {
        this.flavour = flavour;
    }

    @Override
    public String getPrefixFromSize(int size) {
        if (size == 1) {
            return ".byte";
        } else if (size == 2) {
            return (this.flavour == GBASystemType.FLAVOUR_0) ? ".2byte" : ".hword";
        } else if (size == 4) {
            return (this.flavour == GBASystemType.FLAVOUR_0) ? ".4byte" : ".word";
        } else {
            throw new IllegalArgumentException("Invalid GBASystemType size of " + size + "!");
        }
    }

    @Override
    public long fileOffsetToAddress(long address) {
        return Math.addExact(address, GBASystemType.GBA_VMA_OFFSET);
    }

    @Override
    public long addressToFileOffset(long address) {
        return Math.subtractExact(address, GBASystemType.GBA_VMA_OFFSET);
    }

    @Override
    public String getHexPrefix() {
        return "0x";
    }

    @Override
    public String getBinaryPrefix() {
        return "0b";
    }

    @Override
    public Endianness getDefaultEndianness() {
        return Endianness.LITTLE;
    }
}
