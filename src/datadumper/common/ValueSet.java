package datadumper.common;

import datadumper.ValueType;

public class ValueSet {

    private ValueType lowerBound;
    private ValueType upperBound;

    public ValueSet(long singleValueAsLong) {
        this(new Value(singleValueAsLong), new Value(singleValueAsLong));
    }

    public ValueSet(ValueType singleValue) {
        this(singleValue, singleValue);
    }
    
    public ValueSet(long lowerBoundAsLong, long upperBoundAsLong) {
        this(new Value(lowerBoundAsLong), new Value(upperBoundAsLong));
    }

    public ValueSet(ValueType lowerBound, ValueType upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean contains(ValueType value) {
        return this.lowerBound.getValue() <= value.getValue() && value.getValue() <= this.upperBound.getValue();
    }
}
