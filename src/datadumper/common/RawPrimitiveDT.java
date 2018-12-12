package datadumper.common;

import java.math.BigInteger;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.PrimitiveDT;

public class RawPrimitiveDT extends PrimitiveDT {

    protected int size;
    protected String formatStr;

    public RawPrimitiveDT(DataDumper dumper, FormatType format, String formatStr) {
        super(dumper, format);
        this.formatStr = formatStr;
        try {
            // only supports 9 bytes at most, maybe fix?
            this.size = Integer.parseInt(formatStr.substring(0, 1));
            if (this.size == 0) {
                new IllegalArgumentException("First character of RawPrimitiveDT::formatNum formatStr is not a positive integer!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("First character of RawPrimitiveDT::formatNum formatStr is not a positive integer!", e);
        }
        if (formatStr.charAt(1) != '%') {
            throw new IllegalArgumentException("Second character of RawPrimitiveDT::formatNum formatStr is not %!");
        }
    }

    public DataType createCopy() {
        return new RawPrimitiveDT(this.dumper, this.format, this.formatStr);
    }

    @Override
    public String getDatatypeAsStr() {
        switch (formatStr.charAt(formatStr.length() - 1)) {
        case 'b':
        case 'B':
            return this.getSystemType().getBinaryPrefix()
                + String.format(formatStr.substring(1, formatStr.length() - 1) + "d", new BigInteger(Long.toBinaryString(this.value)));
        case 'x':
        case 'X':
            return this.getSystemType().getHexPrefix() 
                + String.format(formatStr.substring(1, formatStr.length()), this.value);
        case 'd':
        case 'D':
            return String.format(formatStr.substring(1, formatStr.length()), this.value);
        default:
            throw new IllegalArgumentException("Unknown radix \"" + formatStr.charAt(formatStr.length() - 1) + "\"!");
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
