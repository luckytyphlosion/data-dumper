package datadumper.gba.bn6f;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.RawPrimitiveDT;
import datadumper.common.UnionDT;

public class BattleActorEnumOrMysteryDataInfoDT extends UnionDT {

    protected ConstantType discriminator;

    public BattleActorEnumOrMysteryDataInfoDT(DataDumper dumper, FormatType format, ConstantType discriminator) {
        super(dumper, format);
        this.discriminator = discriminator;
    }

    @Override
    public DataType getChosenDataType() {
        if (this.discriminator == BattleObjectSetupObjectTypeConstDT.BattleObjectSetupObjectTypeConst.BATTLE_OBJECT_TYPE_MYSTERY_DATA) {
            return new RawPrimitiveDT(this.dumper, FormatType.BLOCK, "2%02x");
        } else if (this.discriminator
            == BattleObjectSetupObjectTypeConstDT.BattleObjectSetupObjectTypeConst.BATTLE_OBJECT_TYPE_BLUE_SIDE
            || this.discriminator
            == BattleObjectSetupObjectTypeConstDT.BattleObjectSetupObjectTypeConst.BATTLE_OBJECT_TYPE_RED_SIDE) {
            return new BattleActorEnumDT(this.dumper, FormatType.BLOCK);
        } else {
            return new RawPrimitiveDT(this.dumper, FormatType.BLOCK, "2%d");
        }
    }

}
