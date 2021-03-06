package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class GlitchMoveEnumDT extends EnumDT {

    public enum MoveEnum implements EnumType {
        NO_MOVE,
        POUND,
        KARATE_CHOP,
        DOUBLESLAP,
        COMET_PUNCH,
        MEGA_PUNCH,
        PAY_DAY,
        FIRE_PUNCH,
        ICE_PUNCH,
        THUNDERPUNCH,
        SCRATCH,
        VICEGRIP,
        GUILLOTINE,
        RAZOR_WIND,
        SWORDS_DANCE,
        CUT,
        GUST,
        WING_ATTACK,
        WHIRLWIND,
        FLY,
        BIND,
        SLAM,
        VINE_WHIP,
        STOMP,
        DOUBLE_KICK,
        MEGA_KICK,
        JUMP_KICK,
        ROLLING_KICK,
        SAND_ATTACK,
        HEADBUTT,
        HORN_ATTACK,
        FURY_ATTACK,
        HORN_DRILL,
        TACKLE,
        BODY_SLAM,
        WRAP,
        TAKE_DOWN,
        THRASH,
        DOUBLE_EDGE,
        TAIL_WHIP,
        POISON_STING,
        TWINEEDLE,
        PIN_MISSILE,
        LEER,
        BITE,
        GROWL,
        ROAR,
        SING,
        SUPERSONIC,
        SONICBOOM,
        DISABLE,
        ACID,
        EMBER,
        FLAMETHROWER,
        MIST,
        WATER_GUN,
        HYDRO_PUMP,
        SURF,
        ICE_BEAM,
        BLIZZARD,
        PSYBEAM,
        BUBBLEBEAM,
        AURORA_BEAM,
        HYPER_BEAM,
        PECK,
        DRILL_PECK,
        SUBMISSION,
        LOW_KICK,
        COUNTER,
        SEISMIC_TOSS,
        STRENGTH,
        ABSORB,
        MEGA_DRAIN,
        LEECH_SEED,
        GROWTH,
        RAZOR_LEAF,
        SOLARBEAM,
        POISONPOWDER,
        STUN_SPORE,
        SLEEP_POWDER,
        PETAL_DANCE,
        STRING_SHOT,
        DRAGON_RAGE,
        FIRE_SPIN,
        THUNDERSHOCK,
        THUNDERBOLT,
        THUNDER_WAVE,
        THUNDER,
        ROCK_THROW,
        EARTHQUAKE,
        FISSURE,
        DIG,
        TOXIC,
        CONFUSION,
        PSYCHIC_M,
        HYPNOSIS,
        MEDITATE,
        AGILITY,
        QUICK_ATTACK,
        RAGE,
        TELEPORT,
        NIGHT_SHADE,
        MIMIC,
        SCREECH,
        DOUBLE_TEAM,
        RECOVER,
        HARDEN,
        MINIMIZE,
        SMOKESCREEN,
        CONFUSE_RAY,
        WITHDRAW,
        DEFENSE_CURL,
        BARRIER,
        LIGHT_SCREEN,
        HAZE,
        REFLECT,
        FOCUS_ENERGY,
        BIDE,
        METRONOME,
        MIRROR_MOVE,
        SELFDESTRUCT,
        EGG_BOMB,
        LICK,
        SMOG,
        SLUDGE,
        BONE_CLUB,
        FIRE_BLAST,
        WATERFALL,
        CLAMP,
        SWIFT,
        SKULL_BASH,
        SPIKE_CANNON,
        CONSTRICT,
        AMNESIA,
        KINESIS,
        SOFTBOILED,
        HI_JUMP_KICK,
        GLARE,
        DREAM_EATER,
        POISON_GAS,
        BARRAGE,
        LEECH_LIFE,
        LOVELY_KISS,
        SKY_ATTACK,
        TRANSFORM,
        BUBBLE,
        DIZZY_PUNCH,
        SPORE,
        FLASH,
        PSYWAVE,
        SPLASH,
        ACID_ARMOR,
        CRABHAMMER,
        EXPLOSION,
        FURY_SWIPES,
        BONEMERANG,
        REST,
        ROCK_SLIDE,
        HYPER_FANG,
        SHARPEN,
        CONVERSION,
        TRI_ATTACK,
        SUPER_FANG,
        SLASH,
        SUBSTITUTE,
        STRUGGLE,
        SUPER_GLITCH_a6,
        SUPER_GLITCH_a7,
        SUPER_GLITCH_a8,
        SUPER_GLITCH_a9,
        SUPER_GLITCH_aa,
        SUPER_GLITCH_ab,
        SUPER_GLITCH_ac,
        SUPER_GLITCH_ad,
        SUPER_GLITCH_ae,
        SUPER_GLITCH_af,
        SUPER_GLITCH_b0,
        SUPER_GLITCH_b1,
        SUPER_GLITCH_b2,
        SUPER_GLITCH_b3,
        SUPER_GLITCH_b4,
        SUPER_GLITCH_b5,
        SUPER_GLITCH_b6,
        SUPER_GLITCH_b7,
        SUPER_GLITCH_b8,
        SUPER_GLITCH_b9,
        SUPER_GLITCH_ba,
        SUPER_GLITCH_bb,
        SUPER_GLITCH_bc,
        SUPER_GLITCH_bd,
        SUPER_GLITCH_be,
        SUPER_GLITCH_bf,
        SUPER_GLITCH_c0,
        SUPER_GLITCH_c1,
        SUPER_GLITCH_c2,
        SUPER_GLITCH_c3,
        MOVE_HM01,
        MOVE_HM02,
        MOVE_HM03,
        MOVE_HM04,
        MOVE_HM05,
        MOVE_TM01,
        MOVE_TM02,
        MOVE_TM03,
        MOVE_TM04,
        MOVE_TM05,
        MOVE_TM06,
        MOVE_TM07,
        MOVE_TM08,
        MOVE_TM09,
        MOVE_TM10,
        MOVE_TM11,
        MOVE_TM12,
        MOVE_TM13,
        MOVE_TM14,
        MOVE_TM15,
        MOVE_TM16,
        MOVE_TM17,
        MOVE_TM18,
        MOVE_TM19,
        MOVE_TM20,
        MOVE_TM21,
        MOVE_TM22,
        MOVE_TM23,
        MOVE_TM24,
        MOVE_TM25,
        MOVE_TM26,
        MOVE_TM27,
        MOVE_TM28,
        MOVE_TM29,
        MOVE_TM30,
        MOVE_TM31,
        MOVE_TM32,
        MOVE_TM33,
        MOVE_TM34,
        MOVE_TM35,
        MOVE_TM36,
        MOVE_TM37,
        MOVE_TM38,
        MOVE_TM39,
        MOVE_TM40,
        MOVE_TM41,
        MOVE_TM42,
        MOVE_TM43,
        MOVE_TM44,
        MOVE_TM45,
        MOVE_TM46,
        MOVE_TM47,
        MOVE_TM48,
        MOVE_TM49,
        MOVE_TM50,
        MOVE_TM51,
        MOVE_TM52,
        MOVE_TM53,
        MOVE_TM54,
        MOVE_TM55;
    };

    public GlitchMoveEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public GlitchMoveEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return GlitchMoveEnumDT.MoveEnum.values();
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
