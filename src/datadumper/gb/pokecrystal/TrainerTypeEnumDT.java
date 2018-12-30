package datadumper.gb.pokecrystal;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class TrainerTypeEnumDT extends EnumDT {

    public enum TrainerTypeEnum implements EnumType {
        TRAINERTYPE_NORMAL,
        TRAINERTYPE_MOVES,
        TRAINERTYPE_ITEM,
        TRAINERTYPE_ITEM_MOVES
    }

    public TrainerTypeEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public TrainerTypeEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return TrainerTypeEnumDT.TrainerTypeEnum.values();
    }

    @Override
    public int getStartingValue() {
        return 0;
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
