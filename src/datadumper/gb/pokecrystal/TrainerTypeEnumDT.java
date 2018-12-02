package datadumper.gb.pokecrystal;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class TrainerTypeEnumDT extends EnumDT {

    public enum TrainerTypeEnum {
        TRAINERTYPE_NORMAL,
        TRAINERTYPE_MOVES,
        TRAINERTYPE_ITEM,
        TRAINERTYPE_ITEM_MOVES
    }

    public TrainerTypeEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public TrainerTypeEnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public Enum<?>[] getEnumNameArray() {
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

}
