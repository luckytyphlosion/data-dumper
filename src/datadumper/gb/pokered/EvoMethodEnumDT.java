package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class EvoMethodEnumDT extends EnumDT {

    public enum EvoMethodEnum {
        EV_ERROR, EV_LEVEL, EV_ITEM, EV_TRADE
    }

    protected SystemType systemType = SystemTypes.gb;

    public EvoMethodEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public EvoMethodEnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public Enum<?>[] getEnumNameArray() {
        return EvoMethodEnumDT.EvoMethodEnum.values();
    }

    @Override
    public int getStartingValue() {
        return 1;
    }

    @Override
    public int getSize() {
        return GBPrimitive.BYTE;
    }
}
