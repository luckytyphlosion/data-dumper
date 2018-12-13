package datadumper;

public class QueuedDataType {
    public final DataType dataType;
    public final long address;
    public final String parentBaseLabel;

    public QueuedDataType(DataType dataType, long address, String parentBaseLabel) {
        this.dataType = dataType;
        this.address = address;
        this.parentBaseLabel = parentBaseLabel;
    }
}
