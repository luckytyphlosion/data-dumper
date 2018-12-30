package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.common.EnumDT;
import datadumper.gba.GBAPrimitive;

public class BattleModeEnumDT extends EnumDT {

    public enum BattleModeEnum implements EnumType {
        BATTLE_MODE_NORMAL,
        BATTLE_MODE_CROSSOVER,
        BATTLE_MODE_TUTORIAL_1,
        BATTLE_MODE_TUTORIAL_2,
        BATTLE_MODE_TUTORIAL_3,
        BATTLE_MODE_BEAST_OUT_TUTORIAL,
        BATTLE_MODE_VIRUS_BATTLER,
        BATTLE_MODE_TOMAHAWKMAN_MINI_GAME,
        BATTLE_MODE_CROSS_TUTORIAL,
        BATTLE_MODE_DUSTMAN_MINI_GAME,
        BATTLE_MODE_HAKUSHAKU_INVINCIBLE_MODE,
        BATTLE_MODE_HAKUSHAKU_DEFEAT;
    }

    public BattleModeEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public BattleModeEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return BattleModeEnumDT.BattleModeEnum.values();
    }

    @Override
    public int getStartingValue() {
        return 0;
    }

    @Override
    public int getSize() {
        return GBAPrimitive.BYTE;
    }

}
