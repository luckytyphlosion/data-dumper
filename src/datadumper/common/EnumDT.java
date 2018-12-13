package datadumper.common;

import com.google.common.base.CaseFormat;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.EnumType;
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

    public abstract EnumType[] getEnumNameArray();

    public abstract int getStartingValue();

    public String getEnumLabelNameFromIndex(int index) {
        return this.getEnumNameArray()[index].getEnumLabelName();
    }
}
