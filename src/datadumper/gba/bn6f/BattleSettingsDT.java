package datadumper.gba.bn6f;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.TemplateDT;

public class BattleSettingsDT extends TemplateDT {

    public BattleSettingsDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public BattleSettingsDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return null;
    }

}
