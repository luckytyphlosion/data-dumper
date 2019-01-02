package datadumper.gba.bn6f;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.FormatType;
import datadumper.common.ConstantDT;
import datadumper.gba.GBAPrimitive;

public class BattleObjSetupTypeConstDT extends ConstantDT {

    public BattleObjSetupTypeConstDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public BattleObjSetupTypeConstDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public ConstantType[] getConstantEnumArray() {
        return BattleObjSetupTypeConst.values();
    }

    @Override
    public int getSize() {
        return GBAPrimitive.BYTE;
    }

}
