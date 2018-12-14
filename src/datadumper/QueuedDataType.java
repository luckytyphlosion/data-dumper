package datadumper;

public class QueuedDataType implements Comparable<QueuedDataType> {
    public final DataType dataType;
    public final long address;
    public final String parentBaseLabel;
    private long endAddress;
    private boolean parsed;

    public QueuedDataType(DataType dataType, long address, String parentBaseLabel) {
        this.dataType = dataType;
        this.address = address;
        this.parentBaseLabel = parentBaseLabel;
        this.parsed = false;
    }

    @Override
    public int compareTo(QueuedDataType queuedDataType) {
        if (this.address == queuedDataType.address) {
            return 0;
        } else if (this.address > queuedDataType.address) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public void setEndAddress(long endAddress) {
        this.endAddress = endAddress;
    }
    
    public long getEndAddress() {
        return this.endAddress;
    }
    
    public void setParsedTrue() {
        this.parsed = true;
    }
    
    public boolean isParsed() {
        return this.parsed;
    }
}
