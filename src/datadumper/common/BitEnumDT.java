package datadumper.common;

import datadumper.DataDumper;
import datadumper.FormatType;
import datadumper.ValueType;
import datadumper.common.PrimitiveDT;

import java.util.StringJoiner;
import java.util.TreeSet;

public abstract class BitEnumDT extends PrimitiveDT {

    protected TreeSet<Enum<?>> bitfield;

    public BitEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
        this.bitfield = new TreeSet<Enum<?>>();
    }

    public BitEnumDT(DataDumper dumper, FormatType format, String varId) {
        super(dumper, format, varId);
    }

    @Override
    public ValueType getValueType() {
        throw new UnsupportedOperationException("ValueType not supported for BitEnumDT yet, maybe later in refactor relating to size of PrimitiveDT.");
    }

    @Override
    public void parseData() {
        this.parseValue();
        long value = this.getValue();
        Enum<?>[] bitfieldEnums = this.getEnumNameArray();
        for (int i = 0; value != 0; i++) {
            if ((value & 1) == 1) {
                this.bitfield.add(bitfieldEnums[i]);
            }
            value >>= 1;
        }
        this.addVariable();
    }

    @Override
    public String getDatatypeAsStr() {
        StringJoiner output = new StringJoiner(" | ");
        for (Enum<?> enumObj : this.bitfield) {
            output.add(enumObj.toString());
        }
        return output.toString();
    }

    public abstract Enum<?>[] getEnumNameArray();

    public abstract int getStartingValue();

}
