package datadumper.common;

import java.util.Arrays;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.FormatType;
import datadumper.ValueType;

public abstract class ConstantDT extends PrimitiveDT {

    protected ConstantType constantValue;

    public ConstantDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public ConstantDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public void parseData() {
        super.parseData();
        this.constantValue = Arrays.stream(this.getConstantEnumArray())
            .filter(c -> c.getValue() == this.value)
            .findFirst()
            .orElseThrow(() -> new RuntimeException(
                String.format("%s value %s at %x is not in discontinuous values!",
                    this.getClass().getName(), this.value, this.getVirtualAddress())
                )
            );
    }
    @Override
    public String getDatatypeAsStr() {
        return this.constantValue.toString();
    }

    @Override
    public ValueType getValueType() {
        return this.constantValue;
    }

    // override this
    public abstract ConstantType[] getConstantEnumArray();

    public ConstantType getConstantValue() {
        return this.constantValue;
    }
}
