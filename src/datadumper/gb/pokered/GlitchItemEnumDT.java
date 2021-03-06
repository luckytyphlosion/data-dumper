package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class GlitchItemEnumDT extends EnumDT {

    public enum ItemEnum implements EnumType {
        NO_ITEM,
        MASTER_BALL,
        ULTRA_BALL,
        GREAT_BALL,
        POKE_BALL,
        TOWN_MAP,
        BICYCLE,
        SURFBOARD,
        SAFARI_BALL,
        POKEDEX,
        MOON_STONE,
        ANTIDOTE,
        BURN_HEAL,
        ICE_HEAL,
        AWAKENING,
        PARLYZ_HEAL,
        FULL_RESTORE,
        MAX_POTION,
        HYPER_POTION,
        SUPER_POTION,
        POTION,
        BOULDERBADGE,
        CASCADEBADGE,
        THUNDERBADGE,
        RAINBOWBADGE,
        SOULBADGE,
        MARSHBADGE,
        VOLCANOBADGE,
        EARTHBADGE,
        ESCAPE_ROPE,
        REPEL,
        OLD_AMBER,
        FIRE_STONE,
        THUNDER_STONE,
        WATER_STONE,
        HP_UP,
        PROTEIN,
        IRON,
        CARBOS,
        CALCIUM,
        RARE_CANDY,
        DOME_FOSSIL,
        HELIX_FOSSIL,
        SECRET_KEY,
        UNUSED_ITEM,
        BIKE_VOUCHER,
        X_ACCURACY,
        LEAF_STONE,
        CARD_KEY,
        NUGGET,
        PP_UP_2,
        POKE_DOLL,
        FULL_HEAL,
        REVIVE,
        MAX_REVIVE,
        GUARD_SPEC,
        SUPER_REPEL,
        MAX_REPEL,
        DIRE_HIT,
        COIN,
        FRESH_WATER,
        SODA_POP,
        LEMONADE,
        S_S_TICKET,
        GOLD_TEETH,
        X_ATTACK,
        X_DEFEND,
        X_SPEED,
        X_SPECIAL,
        COIN_CASE,
        OAKS_PARCEL,
        ITEMFINDER,
        SILPH_SCOPE,
        POKE_FLUTE,
        LIFT_KEY,
        EXP_ALL,
        OLD_ROD,
        GOOD_ROD,
        SUPER_ROD,
        PP_UP,
        ETHER,
        MAX_ETHER,
        ELIXER,
        MAX_ELIXER,
        FLOOR_B2F,
        FLOOR_B1F,
        FLOOR_1F,
        FLOOR_2F,
        FLOOR_3F,
        FLOOR_4F,
        FLOOR_5F,
        FLOOR_6F,
        FLOOR_7F,
        FLOOR_8F,
        FLOOR_9F,
        FLOOR_10F,
        FLOOR_11F,
        FLOOR_B4F,
        GLITCH_ITEM_62,
        GLITCH_ITEM_63,
        GLITCH_ITEM_64,
        GLITCH_ITEM_65,
        GLITCH_ITEM_66,
        GLITCH_ITEM_67,
        GLITCH_ITEM_68,
        GLITCH_ITEM_69,
        GLITCH_ITEM_6a,
        GLITCH_ITEM_6b,
        GLITCH_ITEM_6c,
        GLITCH_ITEM_6d,
        GLITCH_ITEM_6e,
        GLITCH_ITEM_6f,
        GLITCH_ITEM_70,
        GLITCH_ITEM_71,
        GLITCH_ITEM_72,
        GLITCH_ITEM_73,
        GLITCH_ITEM_74,
        GLITCH_ITEM_75,
        GLITCH_ITEM_76,
        GLITCH_ITEM_77,
        GLITCH_ITEM_78,
        GLITCH_ITEM_79,
        GLITCH_ITEM_7a,
        GLITCH_ITEM_7b,
        GLITCH_ITEM_7c,
        GLITCH_ITEM_7d,
        GLITCH_ITEM_7e,
        GLITCH_ITEM_7f,
        GLITCH_ITEM_80,
        GLITCH_ITEM_81,
        GLITCH_ITEM_82,
        GLITCH_ITEM_83,
        GLITCH_ITEM_84,
        GLITCH_ITEM_85,
        GLITCH_ITEM_86,
        GLITCH_ITEM_87,
        GLITCH_ITEM_88,
        GLITCH_ITEM_89,
        GLITCH_ITEM_8a,
        GLITCH_ITEM_8b,
        GLITCH_ITEM_8c,
        GLITCH_ITEM_8d,
        GLITCH_ITEM_8e,
        GLITCH_ITEM_8f,
        GLITCH_ITEM_90,
        GLITCH_ITEM_91,
        GLITCH_ITEM_92,
        GLITCH_ITEM_93,
        GLITCH_ITEM_94,
        GLITCH_ITEM_95,
        GLITCH_ITEM_96,
        GLITCH_ITEM_97,
        GLITCH_ITEM_98,
        GLITCH_ITEM_99,
        GLITCH_ITEM_9a,
        GLITCH_ITEM_9b,
        GLITCH_ITEM_9c,
        GLITCH_ITEM_9d,
        GLITCH_ITEM_9e,
        GLITCH_ITEM_9f,
        GLITCH_ITEM_a0,
        GLITCH_ITEM_a1,
        GLITCH_ITEM_a2,
        GLITCH_ITEM_a3,
        GLITCH_ITEM_a4,
        GLITCH_ITEM_a5,
        GLITCH_ITEM_a6,
        GLITCH_ITEM_a7,
        GLITCH_ITEM_a8,
        GLITCH_ITEM_a9,
        GLITCH_ITEM_aa,
        GLITCH_ITEM_ab,
        GLITCH_ITEM_ac,
        GLITCH_ITEM_ad,
        GLITCH_ITEM_ae,
        GLITCH_ITEM_af,
        GLITCH_ITEM_b0,
        GLITCH_ITEM_b1,
        GLITCH_ITEM_b2,
        GLITCH_ITEM_b3,
        GLITCH_ITEM_b4,
        GLITCH_ITEM_b5,
        GLITCH_ITEM_b6,
        GLITCH_ITEM_b7,
        GLITCH_ITEM_b8,
        GLITCH_ITEM_b9,
        GLITCH_ITEM_ba,
        GLITCH_ITEM_bb,
        GLITCH_ITEM_bc,
        GLITCH_ITEM_bd,
        GLITCH_ITEM_be,
        GLITCH_ITEM_bf,
        GLITCH_ITEM_c0,
        GLITCH_ITEM_c1,
        GLITCH_ITEM_c2,
        GLITCH_ITEM_c3,
        HM01,
        HM02,
        HM03,
        HM04,
        HM05,
        TM01,
        TM02,
        TM03,
        TM04,
        TM05,
        TM06,
        TM07,
        TM08,
        TM09,
        TM10,
        TM11,
        TM12,
        TM13,
        TM14,
        TM15,
        TM16,
        TM17,
        TM18,
        TM19,
        TM20,
        TM21,
        TM22,
        TM23,
        TM24,
        TM25,
        TM26,
        TM27,
        TM28,
        TM29,
        TM30,
        TM31,
        TM32,
        TM33,
        TM34,
        TM35,
        TM36,
        TM37,
        TM38,
        TM39,
        TM40,
        TM41,
        TM42,
        TM43,
        TM44,
        TM45,
        TM46,
        TM47,
        TM48,
        TM49,
        TM50,
        TM51,
        TM52,
        TM53,
        TM54,
        TM55;
    };

    public GlitchItemEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public GlitchItemEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return GlitchItemEnumDT.ItemEnum.values();
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
