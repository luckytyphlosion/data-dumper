package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.StringToken;

public abstract class PointerDT extends DataType {

    protected long pointerAddress;
    protected String pointerLabel;
    protected String relatedParentBase;
    protected String expandedPointerLabel;

    public PointerDT(DataDumper dumper, FormatType format, String pointerLabel, DataType related) {
        super(dumper, format, related);
        this.pointerLabel = pointerLabel;
        this.relatedParentBase = this.dumper.getParentBaseLabel();
    }

    public PointerDT(DataDumper dumper, FormatType format, String pointerLabel, String relatedParentBase, DataType related) {
        super(dumper, format, related);
        this.pointerLabel = pointerLabel;
        this.relatedParentBase = relatedParentBase;
    }

    @Override
    public DataType createCopy() {
        return DataType.createCopyWithArgs(this,
            new Class[] {DataDumper.class, FormatType.class, String.class, String.class, DataType.class},
            new Object[] {this.dumper, this.format, this.pointerLabel, this.relatedParentBase, this.related.createCopy()});
    }

    @Override
    public void parseData() {
        this.pointerAddress = this.readPointer();
        this.expandedPointerLabel = this.expandFormatSpecifiers();
        this.dumper.addDataTypeToQueue(this.related, this.pointerAddress, this.expandedPointerLabel, this.relatedParentBase);
    }

    public abstract long readPointer();

    public String expandFormatSpecifiers() {
        StringToken stringToken = new StringToken(this.pointerLabel);
        String expandedLabel = "";
        for (char c : stringToken) {
            if (c == '%') {
                char formatSpecifierIdentifier = stringToken.next();
                switch (formatSpecifierIdentifier) {
                case 'p':
                    expandedLabel += this.dumper.getParentBaseLabel();
                    break;
                case 'e':
                    expandedLabel += this.dumper.getCurrentEnumLabel();
                    break;
                case 'n':
                    expandedLabel += this.dumper.getCurrentLoopIndex();
                    break;
                case 'a':
                    expandedLabel += this.getPointerAddressAsString();
                    break;
                case '%':
                    expandedLabel += "%";
                    break;
                default:
                    throw new UnsupportedOperationException(String.format("Illegal format specifier \"%%%c\"!", formatSpecifierIdentifier));
                }
            } else {
                expandedLabel += c;
            }
        }
        return expandedLabel;
    }

    @Override
    public String getDatatypeAsStr() {
        return this.expandedPointerLabel;
    }

    public abstract String getPointerAddressAsString();

}
