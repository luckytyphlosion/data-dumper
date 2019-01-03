package datadumper.common;

import datadumper.DataType;
import datadumper.ValueType;

public class ValueSetDataType {

    public final ValueSet valueSet;
    public final DataType dataType;

    public ValueSetDataType(long singleValueAsLong, DataType dataType) {
        this(new ValueSet(singleValueAsLong), dataType);
    }

    public ValueSetDataType(ValueType singleValue, DataType dataType) {
        this(new ValueSet(singleValue), dataType);
    }

    public ValueSetDataType(long lowerBoundAsLong, long upperBoundAsLong, DataType dataType) {
        this(new ValueSet(lowerBoundAsLong, upperBoundAsLong), dataType);
    }

    public ValueSetDataType(ValueType lowerBound, ValueType upperBound, DataType dataType) {
        this(new ValueSet(lowerBound, upperBound), dataType);
    }

    public ValueSetDataType(DataType dataType, String setFormat, ValueType ... setArgs) {
        this(new ValueSet(setFormat, setArgs), dataType);
    }

    public ValueSetDataType(String setFormat, ValueType[] setArgs, DataType dataType) {
        this(new ValueSet(setFormat, setArgs), dataType);
    }

    public ValueSetDataType(ValueSet valueSet, DataType dataType) {
        this.valueSet = valueSet;
        this.dataType = dataType;
    }

}
