package datadumper.common;

import datadumper.ConstantType;
import datadumper.DataDumper;
import datadumper.EnumType;
import datadumper.FormatType;
import datadumper.ValueType;

import java.util.Arrays;

public abstract class EnumDT extends PrimitiveDT {

    public static final ConstantType[] noDiscontinuousValues = new ConstantType[0];
    
    protected ConstantType discontinuousValue;

    public EnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public EnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public void parseData() {
        this.parseValue();
        if (this.value >= this.getEnumNameArray().length) {
            this.discontinuousValue = Arrays.stream(this.getDiscontinuousValues())
                .filter(c -> c.getValue() == this.value)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                    String.format("%s value %s at %x is greater than enum name array length %s and is not in discontinuous values!",
                        this.getClass().getName(), this.value, this.getVirtualAddress(), this.getEnumNameArray().length)
                    )
                );
        }
        this.addVariable();
    }

    @Override
    public String getDatatypeAsStr() {
        return this.getValueType().toString();
    }

    public abstract EnumType[] getEnumNameArray();

    public abstract int getStartingValue();

    public ValueType getValueType() {
        if (this.value < this.getEnumNameArray().length) {
            return this.getEnumNameArray()[Math.toIntExact(this.value)];
        } else {
            return this.discontinuousValue;
        }
    }

    public String getEnumLabelNameFromIndex(int index) {
        return this.getEnumNameArray()[index].getEnumLabelName();
    }

    // override this
    public ConstantType[] getDiscontinuousValues() {
        return EnumDT.noDiscontinuousValues;
    }
}
