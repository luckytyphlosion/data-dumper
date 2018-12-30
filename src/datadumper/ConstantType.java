package datadumper;

// required for a common method to get the value of a defined enum constant (which would be defined via a constructor)
public interface ConstantType extends ValueType {
    public Enum<?> getEnum();
}
