package datadumper.common;

import datadumper.DataDumper;
import datadumper.FormatType;
import datadumper.common.PrimitiveDT;

import java.util.StringJoiner;
import java.util.TreeSet;

public abstract class BitEnumDT extends PrimitiveDT {

    protected TreeSet<Enum<?>> bitfield;

    public BitEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
        this.bitfield = new TreeSet<Enum<?>>();
    }

    @Override
    public void parseData() {
        super.parseData();
        long value = this.getValue();
        Enum<?>[] bitfieldEnums = this.getEnumNameArray();
        for (int i = 0; value != 0; i++) {
            if ((value & 1) == 1) {
                this.bitfield.add(bitfieldEnums[i]);
            }
            value >>= 1;
        }
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
