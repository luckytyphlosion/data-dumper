package datadumper.gb.pokered;

import com.google.common.base.CaseFormat;

import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class PokemonEnumDT extends EnumDT {

    public enum PokemonEnum implements EnumType {
        NO_POKEMON,
        RHYDON,
        KANGASKHAN,
        NIDORAN_M,
        CLEFAIRY,
        SPEAROW,
        VOLTORB,
        NIDOKING,
        SLOWBRO,
        IVYSAUR,
        EXEGGUTOR,
        LICKITUNG,
        EXEGGCUTE,
        GRIMER,
        GENGAR,
        NIDORAN_F,
        NIDOQUEEN,
        CUBONE,
        RHYHORN,
        LAPRAS,
        ARCANINE,
        MEW,
        GYARADOS,
        SHELLDER,
        TENTACOOL,
        GASTLY,
        SCYTHER,
        STARYU,
        BLASTOISE,
        PINSIR,
        TANGELA,
        MISSINGNO_1F(true),
        MISSINGNO_20(true),
        GROWLITHE,
        ONIX,
        FEAROW,
        PIDGEY,
        SLOWPOKE,
        KADABRA,
        GRAVELER,
        CHANSEY,
        MACHOKE,
        MR_MIME,
        HITMONLEE,
        HITMONCHAN,
        ARBOK,
        PARASECT,
        PSYDUCK,
        DROWZEE,
        GOLEM,
        MISSINGNO_32(true),
        MAGMAR,
        MISSINGNO_34(true),
        ELECTABUZZ,
        MAGNETON,
        KOFFING,
        MISSINGNO_38(true),
        MANKEY,
        SEEL,
        DIGLETT,
        TAUROS,
        MISSINGNO_3D(true),
        MISSINGNO_3E(true),
        MISSINGNO_3F(true),
        FARFETCHD,
        VENONAT,
        DRAGONITE,
        MISSINGNO_43(true),
        MISSINGNO_44(true),
        MISSINGNO_45(true),
        DODUO,
        POLIWAG,
        JYNX,
        MOLTRES,
        ARTICUNO,
        ZAPDOS,
        DITTO,
        MEOWTH,
        KRABBY,
        MISSINGNO_4F(true),
        MISSINGNO_50(true),
        MISSINGNO_51(true),
        VULPIX,
        NINETALES,
        PIKACHU,
        RAICHU,
        MISSINGNO_56(true),
        MISSINGNO_57(true),
        DRATINI,
        DRAGONAIR,
        KABUTO,
        KABUTOPS,
        HORSEA,
        SEADRA,
        MISSINGNO_5E(true),
        MISSINGNO_5F(true),
        SANDSHREW,
        SANDSLASH,
        OMANYTE,
        OMASTAR,
        JIGGLYPUFF,
        WIGGLYTUFF,
        EEVEE,
        FLAREON,
        JOLTEON,
        VAPOREON,
        MACHOP,
        ZUBAT,
        EKANS,
        PARAS,
        POLIWHIRL,
        POLIWRATH,
        WEEDLE,
        KAKUNA,
        BEEDRILL,
        MISSINGNO_73(true),
        DODRIO,
        PRIMEAPE,
        DUGTRIO,
        VENOMOTH,
        DEWGONG,
        MISSINGNO_79(true),
        MISSINGNO_7A(true),
        CATERPIE,
        METAPOD,
        BUTTERFREE,
        MACHAMP,
        MISSINGNO_7F(true),
        GOLDUCK,
        HYPNO,
        GOLBAT,
        MEWTWO,
        SNORLAX,
        MAGIKARP,
        MISSINGNO_86(true),
        MISSINGNO_87(true),
        MUK,
        MISSINGNO_89(true),
        KINGLER,
        CLOYSTER,
        MISSINGNO_8C(true),
        ELECTRODE,
        CLEFABLE,
        WEEZING,
        PERSIAN,
        MAROWAK,
        MISSINGNO_92(true),
        HAUNTER,
        ABRA,
        ALAKAZAM,
        PIDGEOTTO,
        PIDGEOT,
        STARMIE,
        BULBASAUR,
        VENUSAUR,
        TENTACRUEL,
        MISSINGNO_9C(true),
        GOLDEEN,
        SEAKING,
        MISSINGNO_9F(true),
        MISSINGNO_A0(true),
        MISSINGNO_A1(true),
        MISSINGNO_A2(true),
        PONYTA,
        RAPIDASH,
        RATTATA,
        RATICATE,
        NIDORINO,
        NIDORINA,
        GEODUDE,
        PORYGON,
        AERODACTYL,
        MISSINGNO_AC(true),
        MAGNEMITE,
        MISSINGNO_AE(true),
        MISSINGNO_AF(true),
        CHARMANDER,
        SQUIRTLE,
        CHARMELEON,
        WARTORTLE,
        CHARIZARD,
        MISSINGNO_B5(true),
        FOSSIL_KABUTOPS,
        FOSSIL_AERODACTYL,
        MON_GHOST,
        ODDISH,
        GLOOM,
        VILEPLUME,
        BELLSPROUT,
        WEEPINBELL,
        VICTREEBEL;

        private boolean endHexIdentifier;
        PokemonEnum() {
            this(false);
        }
        
        PokemonEnum(boolean endHexIdentifier) {
            this.endHexIdentifier = endHexIdentifier;
        }
        
        @Override
        public String getEnumLabelName() {
            if (this.endHexIdentifier) {
                String enumStr = super.toString();
                int i = enumStr.lastIndexOf("_");
                if (i == -1) {
                    return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, enumStr);
                }
                return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, enumStr.substring(0, i))
                    + enumStr.substring(i + 1);
            } else {
                return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, super.toString());
            }
        }
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
    
    @Override
    public SystemType getSystemType() {
        return SystemTypes.gb;
    }
}
