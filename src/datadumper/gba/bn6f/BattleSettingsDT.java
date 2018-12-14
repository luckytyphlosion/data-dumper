package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.DecByteDT;
import datadumper.common.FormatDT;
import datadumper.common.HexByteDT;
import datadumper.common.RawPrimitiveDT;
import datadumper.common.SentinelListDT;
import datadumper.common.TemplateDT;
import datadumper.gba.GBAPointerDT;

public class BattleSettingsDT extends TemplateDT {

    public BattleSettingsDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return new DataType[] {
            new BattlefieldEnumDT(dumper, FormatType.BLOCK),
            new HexByteDT(dumper, FormatType.INLINE),
            new MusicEnumDT(dumper, FormatType.INLINE),
            new BattleModeEnumDT(dumper, FormatType.INLINE),
            new BattleBGEnumDT(dumper, FormatType.INLINE),
            new DecByteDT(dumper, FormatType.INLINE),
            new RawPrimitiveDT(dumper, FormatType.INLINE, "1%06b"),
            new HexByteDT(dumper, FormatType.INLINE),
            new BattleEffectBitEnumDT(dumper, FormatType.BLOCK),
            new GBAPointerDT(dumper, FormatType.BLOCK, "ObjectSetupPointer%p%n",
                new SentinelListDT(dumper, FormatType.NONE, "1%02x", 0xf0, FormatType.BLOCK, 
                    new BattleObjectSetupDT(this.dumper, FormatType.NONE)
                )
            ),
            new FormatDT(dumper, FormatType.NONE, "\n")
        };
    }

}
