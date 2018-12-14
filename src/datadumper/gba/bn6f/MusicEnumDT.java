package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.common.EnumDT;
import datadumper.gba.GBAPrimitive;

public class MusicEnumDT extends EnumDT {

    public enum MusicEnum implements EnumType {
        MUSIC_NONE,
        MUSIC_TITLE_SCREEN,
        MUSIC_WWW,
        MUSIC_CYBER_CITY,
        MUSIC_INDOORS,
        MUSIC_SCHOOL,
        MUSIC_SEASIDE_TOWN,
        MUSIC_SKY_TOWN,
        MUSIC_GREEN_TOWN,
        MUSIC_GRAVEYARD_AREA,
        MUSIC_MR_WEATHER_COMP,
        MUSIC_EVENT_OCCURRENCE,
        MUSIC_CRISIS_THEME,
        MUSIC_SAD_THEME,
        MUSIC_HERO_THEME,
        MUSIC_TRANSMISSION,
        MUSIC_ROBO_CONTROL_COMP,
        MUSIC_AQUARIUM_COMP,
        MUSIC_JUDGE_TREE_COMP,
        MUSIC_NETWORK_THEME,
        MUSIC_UNDERNET,
        MUSIC_VIRUS_BATTLE,
        MUSIC_BOSS_BATTLE,
        MUSIC_FINAL_BATTLE,
        MUSIC_PAVILION_OVERWORLD,
        MUSIC_WINNER_THEME,
        MUSIC_LOSER_THEME,
        MUSIC_GAME_OVER,
        MUSIC_BOSS_PRELUDE,
        MUSIC_CREDITS,
        MUSIC_NAVI_CUSTOMIZER,
        MUSIC_WINNER_THEME_SHORT,
        MUSIC_PAVILION_COMP,
        MUSIC_CYBERBEAST_THEME,
        MUSIC_CROSSOVER_BATTLE,
        MUSIC_SHARK_CHASE,
        MUSIC_ACDC_TOWN,
        MUSIC_EXPO_SITE;
    }

    public MusicEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public MusicEnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return MusicEnumDT.MusicEnum.values();
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
