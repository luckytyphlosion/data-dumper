package datadumper.common;

import datadumper.DataType;

public class ValueSetDataType {

    public final ValueSet valueSet;
    public final DataType dataType;

    public ValueSetDataType(ValueSet valueSet, DataType dataType) {
        this.valueSet = valueSet;
        this.dataType = dataType;
    }

}
