package datadumper.gb.pokecrystal;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class PokemonEnumDT extends EnumDT {

    public enum PokemonEnum implements EnumType {
        NO_POKEMON,
        BULBASAUR,
        IVYSAUR,
        VENUSAUR,
        CHARMANDER,
        CHARMELEON,
        CHARIZARD,
        SQUIRTLE,
        WARTORTLE,
        BLASTOISE,
        CATERPIE,
        METAPOD,
        BUTTERFREE,
        WEEDLE,
        KAKUNA,
        BEEDRILL,
        PIDGEY,
        PIDGEOTTO,
        PIDGEOT,
        RATTATA,
        RATICATE,
        SPEAROW,
        FEAROW,
        EKANS,
        ARBOK,
        PIKACHU,
        RAICHU,
        SANDSHREW,
        SANDSLASH,
        NIDORAN_F,
        NIDORINA,
        NIDOQUEEN,
        NIDORAN_M,
        NIDORINO,
        NIDOKING,
        CLEFAIRY,
        CLEFABLE,
        VULPIX,
        NINETALES,
        JIGGLYPUFF,
        WIGGLYTUFF,
        ZUBAT,
        GOLBAT,
        ODDISH,
        GLOOM,
        VILEPLUME,
        PARAS,
        PARASECT,
        VENONAT,
        VENOMOTH,
        DIGLETT,
        DUGTRIO,
        MEOWTH,
        PERSIAN,
        PSYDUCK,
        GOLDUCK,
        MANKEY,
        PRIMEAPE,
        GROWLITHE,
        ARCANINE,
        POLIWAG,
        POLIWHIRL,
        POLIWRATH,
        ABRA,
        KADABRA,
        ALAKAZAM,
        MACHOP,
        MACHOKE,
        MACHAMP,
        BELLSPROUT,
        WEEPINBELL,
        VICTREEBEL,
        TENTACOOL,
        TENTACRUEL,
        GEODUDE,
        GRAVELER,
        GOLEM,
        PONYTA,
        RAPIDASH,
        SLOWPOKE,
        SLOWBRO,
        MAGNEMITE,
        MAGNETON,
        FARFETCH_D,
        DODUO,
        DODRIO,
        SEEL,
        DEWGONG,
        GRIMER,
        MUK,
        SHELLDER,
        CLOYSTER,
        GASTLY,
        HAUNTER,
        GENGAR,
        ONIX,
        DROWZEE,
        HYPNO,
        KRABBY,
        KINGLER,
        VOLTORB,
        ELECTRODE,
        EXEGGCUTE,
        EXEGGUTOR,
        CUBONE,
        MAROWAK,
        HITMONLEE,
        HITMONCHAN,
        LICKITUNG,
        KOFFING,
        WEEZING,
        RHYHORN,
        RHYDON,
        CHANSEY,
        TANGELA,
        KANGASKHAN,
        HORSEA,
        SEADRA,
        GOLDEEN,
        SEAKING,
        STARYU,
        STARMIE,
        MR__MIME,
        SCYTHER,
        JYNX,
        ELECTABUZZ,
        MAGMAR,
        PINSIR,
        TAUROS,
        MAGIKARP,
        GYARADOS,
        LAPRAS,
        DITTO,
        EEVEE,
        VAPOREON,
        JOLTEON,
        FLAREON,
        PORYGON,
        OMANYTE,
        OMASTAR,
        KABUTO,
        KABUTOPS,
        AERODACTYL,
        SNORLAX,
        ARTICUNO,
        ZAPDOS,
        MOLTRES,
        DRATINI,
        DRAGONAIR,
        DRAGONITE,
        MEWTWO,
        MEW,
        CHIKORITA,
        BAYLEEF,
        MEGANIUM,
        CYNDAQUIL,
        QUILAVA,
        TYPHLOSION,
        TOTODILE,
        CROCONAW,
        FERALIGATR,
        SENTRET,
        FURRET,
        HOOTHOOT,
        NOCTOWL,
        LEDYBA,
        LEDIAN,
        SPINARAK,
        ARIADOS,
        CROBAT,
        CHINCHOU,
        LANTURN,
        PICHU,
        CLEFFA,
        IGGLYBUFF,
        TOGEPI,
        TOGETIC,
        NATU,
        XATU,
        MAREEP,
        FLAAFFY,
        AMPHAROS,
        BELLOSSOM,
        MARILL,
        AZUMARILL,
        SUDOWOODO,
        POLITOED,
        HOPPIP,
        SKIPLOOM,
        JUMPLUFF,
        AIPOM,
        SUNKERN,
        SUNFLORA,
        YANMA,
        WOOPER,
        QUAGSIRE,
        ESPEON,
        UMBREON,
        MURKROW,
        SLOWKING,
        MISDREAVUS,
        UNOWN,
        WOBBUFFET,
        GIRAFARIG,
        PINECO,
        FORRETRESS,
        DUNSPARCE,
        GLIGAR,
        STEELIX,
        SNUBBULL,
        GRANBULL,
        QWILFISH,
        SCIZOR,
        SHUCKLE,
        HERACROSS,
        SNEASEL,
        TEDDIURSA,
        URSARING,
        SLUGMA,
        MAGCARGO,
        SWINUB,
        PILOSWINE,
        CORSOLA,
        REMORAID,
        OCTILLERY,
        DELIBIRD,
        MANTINE,
        SKARMORY,
        HOUNDOUR,
        HOUNDOOM,
        KINGDRA,
        PHANPY,
        DONPHAN,
        PORYGON2,
        STANTLER,
        SMEARGLE,
        TYROGUE,
        HITMONTOP,
        SMOOCHUM,
        ELEKID,
        MAGBY,
        MILTANK,
        BLISSEY,
        RAIKOU,
        ENTEI,
        SUICUNE,
        LARVITAR,
        PUPITAR,
        TYRANITAR,
        LUGIA,
        HO_OH,
        CELEBI,
        MON_FC,
        EGG,
        MON_FE,
    }

    public PokemonEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public PokemonEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return PokemonEnumDT.PokemonEnum.values();
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
