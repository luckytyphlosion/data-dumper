package datadumper.gba.bn6f;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.common.EnumDT;
import datadumper.gba.GBAPrimitive;

public class BattleBGEnumDT extends EnumDT {

    public enum BattleBGEnum implements EnumType {
        BATTLE_BG_LAN_HP,
        BATTLE_BG_ACDC_HP,
        BATTLE_BG_NOTHING,
        BATTLE_BG_SEASIDE_HP,
        BATTLE_BG_SKY_HP,
        BATTLE_BG_GREEN_HP,
        BATTLE_BG_ROBO_CONTROL_COMP,
        BATTLE_BG_GENERIC_COMP_GREEN,
        BATTLE_BG_GENERIC_COMP_PURPLE,
        BATTLE_BG_CENTRAL_AREA,
        BATTLE_BG_AQUARIUM_COMP,
        BATTLE_BG_SEASIDE_AREA,
        BATTLE_BG_JUDGEMENT_TREE,
        BATTLE_BG_GREEN_AREA,
        BATTLE_BG_SKY_AREA,
        BATTLE_BG_UNDERNET,
        BATTLE_BG_MR_WEATHER_COMP,
        BATTLE_BG_UNDERGROUND,
        BATTLE_BG_CYBERBEAST_COMP,
        BATTLE_BG_ACDC_AREA,
        BATTLE_BG_GRAVEYARD_AREA,
        BATTLE_BG_MR_WEATHER_COMP_STORM;
    }
    
    public enum BattleBGDiscontEnum implements ConstantType {
        BATTLE_BG_0xff(0xff);
        
        private long value;
        
        BattleBGDiscontEnum(long value) {
            this.value = value;
        }

        @Override
        public long getValue() {
            return this.value;
        }

        @Override
        public Enum<?> getEnum() {
            return this;
        }
    }

    public BattleBGEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public BattleBGEnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public EnumType[] getEnumNameArray() {
        return BattleBGEnumDT.BattleBGEnum.values();
    }

    @Override
    public int getStartingValue() {
        return 0;
    }

    @Override
    public int getSize() {
        return GBAPrimitive.BYTE;
    }
    
    @Override
    public ConstantType[] getDiscontinuousValues() {
        return BattleBGEnumDT.BattleBGDiscontEnum.values();
    }
}
