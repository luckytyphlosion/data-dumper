package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class CommandDT extends UnionDT {

    protected PrimitiveDT commandDataType;

    public CommandDT(DataDumper dumper, FormatType format, PrimitiveDT commandDataType) {
        super(dumper, format);
        this.commandDataType = commandDataType;
    }

    public CommandDT(DataDumper dumper, FormatType format, PrimitiveDT commandDataType, DataType related) {
        super(dumper, format, related);
        this.commandDataType = commandDataType;
    }

    @Override
    public DataType createCopy() {
        return DataType.createCopyWithArgs(this,
            new Class[] {DataDumper.class, FormatType.class, PrimitiveDT.class, DataType.class},
            new Object[] {this.dumper, this.format, this.commandDataType.createCopy(), this.related.createCopy()});
    }

    @Override
    public DataType getChosenDataType() {
        this.commandDataType.parse();
        return this.getPossibleDataTypes()[this.commandDataType.getValueAsInt()];
    }

    @Override
    public String beforeDatatypeAsStr() {
        return this.commandDataType.toString();
    }

    public abstract DataType[] getPossibleDataTypes();

}
