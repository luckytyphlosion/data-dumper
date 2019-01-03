package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.ValueType;

public class VariableSetUnionDT extends SetUnionDT {

    protected ValueSetDataType[] valueSetDataTypeArray;
    protected String varId;

    public VariableSetUnionDT(DataDumper dumper, FormatType format, String varId, ValueSetDataType ... valueSetDataTypeArray) {
        super(dumper, format);
        this.varId = varId;
        this.valueSetDataTypeArray = valueSetDataTypeArray;
    }

    public VariableSetUnionDT(DataDumper dumper, FormatType format, String varId, ValueSetDataType[] valueSetDataTypeArray, DataType related) {
        super(dumper, format, related);
        this.varId = varId;
        this.valueSetDataTypeArray = valueSetDataTypeArray;
    }

    @Override
    public DataType createCopy() {
        ValueSetDataType[] newValueSetDataTypeArray = new ValueSetDataType[this.valueSetDataTypeArray.length];
        for (int i = 0; i < newValueSetDataTypeArray.length; i++) {
            ValueSetDataType valueSetDataType = this.valueSetDataTypeArray[i];
            newValueSetDataTypeArray[i] = new ValueSetDataType(valueSetDataType.valueSet, valueSetDataType.dataType.createCopy());
        }
        return new VariableSetUnionDT(this.dumper, this.format, this.varId, newValueSetDataTypeArray, this.related);
    }

    @Override
    public ValueType getValueTypeDiscriminator() {
        return this.dumper.getVariable(this.varId);
    }

    @Override
    public ValueSetDataType[] getValueSetDataTypeArray() {
        return this.valueSetDataTypeArray;
    }

}
