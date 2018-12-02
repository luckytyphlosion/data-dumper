package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class SentinelTerminatedListDT extends ListDT {

    protected int sentinelSize;
    protected boolean padding;
    protected RadixType radix;
    protected long sentinel;
    protected FormatType sentinelFormat;
    protected RawPrimitiveDT sentinelDataType;

    public SentinelTerminatedListDT(DataDumper dumper, FormatType format, int sentinelSize, RadixType radix, long sentinel, DataType related) {
        this(dumper, format, sentinelSize, false, radix, sentinel, FormatType.BLOCK, related);
    }

    public SentinelTerminatedListDT(DataDumper dumper, FormatType format, int sentinelSize, RadixType radix, long sentinel, FormatType sentinelFormat, DataType related) {
        this(dumper, format, sentinelSize, false, radix, sentinel, sentinelFormat, related);
    }

    public SentinelTerminatedListDT(DataDumper dumper, FormatType format, int sentinelSize, boolean padding, RadixType radix, long sentinel, FormatType sentinelFormat, DataType related) {
        super(dumper, format, related);
        this.sentinelSize = sentinelSize;
        this.padding = padding;
        this.radix = radix;
        this.sentinel = sentinel;
        this.sentinelFormat = sentinelFormat;
    }

    public DataType createCopy() {
        return new SentinelTerminatedListDT(this.dumper, this.format, this.sentinelSize, this.padding, this.radix, this.sentinel, this.sentinelFormat, this.related.createCopy());
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
            this.sentinelDataType = new RawPrimitiveDT(this.dumper, this.sentinelFormat, this.sentinelSize, this.padding, this.radix);
            this.sentinelDataType.parse();
        }
        return notSentinel;
    }

    @Override
    public String getPostLoopDatatypesAsStr() {
        return this.sentinelDataType.toString();
    }
}
