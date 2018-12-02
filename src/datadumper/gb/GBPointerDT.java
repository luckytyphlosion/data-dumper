package datadumper.gb;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.PointerDT;

public class GBPointerDT extends PointerDT {

    public static final long GB_HOME_BANK_END_ADDRESS = 0x4000L;

    public GBPointerDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    public long readPointer() {
        short address = DataDumper.swapShort(this.inputFile.readShort());
        if (address < GBPointerDT.GB_HOME_BANK_END_ADDRESS) {
            return address;
        } else {
            return (this.loadAddress / GBPointerDT.GB_HOME_BANK_END_ADDRESS) * GBPointerDT.GB_HOME_BANK_END_ADDRESS + address - GBPointerDT.GB_HOME_BANK_END_ADDRESS;
        }
    }

    @Override
    public String getDatatypeAsStr() {
        return String.format("Unknown%04x", this.pointerAddress);
    }

    @Override
    public String getBlockFormatPrefix() {
        return "dw";
    }

}
