package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.HexByteDT;
import datadumper.common.RawPrimitiveDT;
import datadumper.common.TemplateDT;
import datadumper.common.ValueSetDataType;
import datadumper.common.VariableSetUnionDT;

public class BattleObjectSetupDT extends TemplateDT {

    public BattleObjectSetupDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return new DataType[] {
            new BattleObjSetupTypeConstDT(this.dumper, FormatType.BLOCK, "objSetupType"),
            new HexByteDT(this.dumper, FormatType.INLINE),
            new VariableSetUnionDT(this.dumper, FormatType.NONE, "objSetupType",
                new ValueSetDataType(
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_MYSTERY_DATA,
                    new RawPrimitiveDT(this.dumper, FormatType.BLOCK, "2%02x")
                ),
                new ValueSetDataType(
                    new BattleActorEnumDT(this.dumper, FormatType.BLOCK),
                    "[] | []",
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_BLUE_SIDE,
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_RED_SIDE
                ),
                new ValueSetDataType(
                    new RawPrimitiveDT(this.dumper, FormatType.BLOCK, "2%d"),
                    "!([] | [] | [])",
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_MYSTERY_DATA,
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_BLUE_SIDE,
                    BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_RED_SIDE
                )
            )
        };
    }

}
