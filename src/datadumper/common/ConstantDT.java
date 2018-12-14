package datadumper.common;

import java.util.Arrays;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class ConstantDT extends PrimitiveDT {

    protected ConstantType constantValue;

    public ConstantDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public ConstantDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
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

    // override this
    public abstract ConstantType[] getConstantEnumArray();

    public ConstantType getConstantValue() {
        return this.constantValue;
    }
}
