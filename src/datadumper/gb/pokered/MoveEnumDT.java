package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class MoveEnumDT extends EnumDT {

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
        SUBSTITUTE
    };

    public MoveEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public MoveEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return MoveEnumDT.MoveEnum.values();
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
