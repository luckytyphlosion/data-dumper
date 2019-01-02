package datadumper;

// exists to simplify defining set bounds
public interface ValueType {
    public long getValue();

    default int compareTo(ValueType value) {
        if (this.getValue() == value.getValue()) {
            return 0;
        } else if (this.getValue() > value.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    default boolean equals(ValueType value) {
        return this.getValue() == value.getValue();
    }
}
