package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class SentinelTerminatedListDT extends ListDT {

    protected long sentinel;
    protected FormatType sentinelFormat;
    protected RawPrimitiveDT sentinelDataType;
    protected String formatStr;
    protected int sentinelSize;

    public SentinelTerminatedListDT(DataDumper dumper, FormatType format, String formatStr, long sentinel, FormatType sentinelFormat, DataType related) {
        super(dumper, format, related);
        this.formatStr = formatStr;
        this.sentinel = sentinel;
        this.sentinelFormat = sentinelFormat;
        try {
            this.sentinelSize = Integer.parseInt(formatStr.substring(0, 1));
            if (this.sentinelSize == 0) {
                new IllegalArgumentException("First character of RawPrimitiveDT::formatNum formatStr is not a positive integer!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("First character of RawPrimitiveDT::formatNum formatStr is not a positive integer!", e);
        }
    }

    public DataType createCopy() {
        return new SentinelTerminatedListDT(this.dumper, this.format, this.formatStr, this.sentinel, this.sentinelFormat, this.related.createCopy());
    }

    @Override
    // maybe make a MaybeDT?
    public boolean loopCondition() {
        // readFromSizeArg
        long tempFilePointer = this.inputFile.getFilePointer();
        // System.out.println(String.format("tempFilePointer: %x | sentinelSize: %s", tempFilePointer, this.sentinelSize));
        boolean notSentinel = this.readFromSizeArg(this.sentinelSize) != this.sentinel;
        this.inputFile.seek(tempFilePointer);
        if (!notSentinel) {
            this.sentinelDataType = new RawPrimitiveDT(this.dumper, this.sentinelFormat, this.formatStr);
            this.sentinelDataType.parse();
        }
        return notSentinel;
    }

    @Override
    public String getPostLoopDatatypesAsStr() {
        return this.sentinelDataType.toString();
    }
}
