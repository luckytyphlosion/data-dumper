package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class EvoMethodEnumDT extends EnumDT {

    public enum EvoMethodEnum implements EnumType {
        EV_ERROR, EV_LEVEL, EV_ITEM, EV_TRADE
    }

    public EvoMethodEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public EvoMethodEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
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
    
    @Override
    public SystemType getSystemType() {
        return SystemTypes.gb;
    }
}
