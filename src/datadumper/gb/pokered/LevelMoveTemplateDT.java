package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.DecByteDT;
import datadumper.common.TemplateDT;

public class LevelMoveTemplateDT extends TemplateDT {

    public LevelMoveTemplateDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public LevelMoveTemplateDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return new DataType[] {
            new DecByteDT(this.dumper, FormatType.BLOCK),
            new MoveEnumDT(this.dumper, FormatType.INLINE)
        };
    }

    @Override
    public SystemType getSystemType() {
        return SystemTypes.gb;
    }

}
