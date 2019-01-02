package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.HexByteDT;

public class BattleObjectSetupDT extends DataType {

    protected BattleObjSetupTypeConstDT objectType;
    protected HexByteDT objectCoords;
    protected BattleActorEnumOrMysteryDataInfoDT battleActorOrMysteryDataInfo;

    public BattleObjectSetupDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public void parseData() {
        this.objectType = new BattleObjSetupTypeConstDT(this.dumper, FormatType.BLOCK);
        this.objectType.parse();
        this.objectCoords = new HexByteDT(this.dumper, FormatType.INLINE);
        this.objectCoords.parse();
        this.battleActorOrMysteryDataInfo = new BattleActorEnumOrMysteryDataInfoDT(this.dumper, FormatType.NONE, this.objectType.getConstantValue());
        this.battleActorOrMysteryDataInfo.parse();
    }

    @Override
    public String getDatatypeAsStr() {
        return this.objectType.toString() + this.objectCoords.toString() + this.battleActorOrMysteryDataInfo.toString();
    }

    @Override
    public String getBlockFormatPrefix() {
        return "";
    }

}
