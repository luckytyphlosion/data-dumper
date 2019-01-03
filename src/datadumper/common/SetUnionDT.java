package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.ValueType;

public abstract class SetUnionDT extends UnionDT {

    public SetUnionDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public SetUnionDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    public DataType getChosenDataType() {
        ValueSetDataType[] valueSetDataTypeArray = this.getValueSetDataTypeArray();
        ValueType valueTypeDiscriminator = this.getValueTypeDiscriminator();
        DataType chosenDataType = DataType.nullDataType;

        for (ValueSetDataType valueSetDataType : valueSetDataTypeArray) {
            if (valueSetDataType.valueSet.contains(valueTypeDiscriminator)) {
                if (chosenDataType != DataType.nullDataType) {
                    throw new RuntimeException(String.format(
                            "Discriminator of class \"%s\" with value \"%d\" exists in multiple sets!",
                            valueTypeDiscriminator.getClass().getName(),
                            valueTypeDiscriminator.getValue()
                        )
                    );
                } else {
                    chosenDataType = valueSetDataType.dataType;
                }
            }
        }
        return chosenDataType;
    }

    public abstract ValueSetDataType[] getValueSetDataTypeArray();

    public abstract ValueType getValueTypeDiscriminator();
}
