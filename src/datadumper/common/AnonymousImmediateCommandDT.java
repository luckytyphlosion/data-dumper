package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class AnonymousImmediateCommandDT extends ImmediateCommandDT {

    protected DataType[] possibleDataTypes;

    public AnonymousImmediateCommandDT(DataDumper dumper, FormatType format, PrimitiveDT commandDataType, DataType[] possibleDataTypes) {
        super(dumper, format, commandDataType);
        this.possibleDataTypes = possibleDataTypes;
    }

    public AnonymousImmediateCommandDT(DataDumper dumper, FormatType format, PrimitiveDT commandDataType, DataType related, DataType[] possibleDataTypes) {
        super(dumper, format, commandDataType, related);
        this.possibleDataTypes = possibleDataTypes;
    }
    
    public DataType createCopy() {
        DataType[] newPossibleDataTypes = new DataType[this.possibleDataTypes.length];
        for (int i = 0; i < newPossibleDataTypes.length; i++) {
            newPossibleDataTypes[i] = this.possibleDataTypes[i].createCopy();
        }

        return new AnonymousImmediateCommandDT(this.dumper, this.format, (PrimitiveDT)this.commandDataType.createCopy(), this.related.createCopy(), newPossibleDataTypes);
    }

    @Override
    public DataType[] getPossibleDataTypes() {
        return this.possibleDataTypes;
    }

}
