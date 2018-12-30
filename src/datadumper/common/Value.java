package datadumper.common;

import datadumper.ValueType;

// TODO use static cache map?
public class Value implements ValueType {

    public final long value;
    
    public Value(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return this.value;
    }
}
