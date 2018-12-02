package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class EnumDT extends PrimitiveDT {

    public EnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public EnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        super.parseData();
        if (this.value >= this.getEnumNameArray().length) {
            throw new RuntimeException(String.format("%s value %s at %x is greater than enum name array length %s!", this.getClass().getName(), this.value, this.getVirtualAddress(), this.getEnumNameArray().length));
        }
    }

    @Override
    public String getDatatypeAsStr() {
        //System.out.println(String.format("%x", this.getLoadAddress()));
        return this.getEnumNameArray()[Math.toIntExact(this.value)].toString();
    }

    public abstract Enum<?>[] getEnumNameArray();

    public abstract int getStartingValue();

    @Override
    public String getBlockFormatPrefix() {
        return this.getSystemType().getPrefixFromSize(this.getSize());
    }

}
