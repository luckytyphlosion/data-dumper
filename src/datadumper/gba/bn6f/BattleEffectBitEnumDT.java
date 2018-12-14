package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.FormatType;
import datadumper.common.BitEnumDT;
import datadumper.gba.GBAPrimitive;

public class BattleEffectBitEnumDT extends BitEnumDT {

    public enum BattleEffectsBitEnum {
        BATTLE_EFFECT_BOSS_RANK,
        BATTLE_EFFECT_SHOW_RESULTS,
        BATTLE_EFFECT_HEAL_BEFORE_BATTLE,
        BATTLE_EFFECT_NETWORK_BATTLE,
        BATTLE_EFFECT_HEAL_AFTER_BATTLE,
        BATTLE_EFFECT_ALLOW_RUNNING_AND_KEEP_FULL_SYNC,
        BATTLE_EFFECT_DONT_HEAL_AFTER_BATTLE,
        BATTLE_EFFECT_RANDOMIZE_FOLDER,
        BATTLE_EFFECT_ALLOW_GAME_OVER,
        BATTLE_EFFECT_UNK_0x200,
        BATTLE_EFFECT_TRIPLE_BATTLE,
        BATTLE_EFFECT_UNK_0x800,
        BATTLE_EFFECT_UNK_0x1000,
        BATTLE_EFFECT_UNK_0x2000,
        BATTLE_EFFECT_ALLOW_LOCENEMY_AND_KEEP_FULL_SYNC,
        BATTLE_EFFECT_NO_RARE_VIRUSES,
        BATTLE_EFFECT_UNK_0x10000,
        BATTLE_EFFECT_UNK_0x20000,
        BATTLE_EFFECT_UNK_0x40000,
        BATTLE_EFFECT_UNK_0x80000,
        BATTLE_EFFECT_NO_DARK_CHIPS,
        BATTLE_EFFECT_UNK_0x200000,
        BATTLE_EFFECT_UNK_0x400000,
        BATTLE_EFFECT_UNK_0x800000;
    }

    public BattleEffectBitEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public Enum<?>[] getEnumNameArray() {
        return BattleEffectBitEnumDT.BattleEffectsBitEnum.values();
    }

    @Override
    public int getStartingValue() {
        return 0;
    }

    @Override
    public int getSize() {
        return GBAPrimitive.WORD;
    }

}
