package datadumper.common;

import java.util.Iterator;
import java.util.Spliterator;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

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
        //System.out.println(expandedLabel);
        return expandedLabel;
    }

    @Override
    public String getDatatypeAsStr() {
        return this.expandedPointerLabel;
    }

    public abstract String getPointerAddressAsString();

    public class StringToken implements Iterable<Character>, Iterator<Character> {
        private String token;
        private int pos;

        public StringToken(String token) {
            this.token = token;
            this.pos = 0;
        }
        
        public char readToken() {
            if (this.pos < this.token.length()) {
                
            }
            return this.token.charAt(pos++);
        }

        @Override
        public boolean hasNext() {
            return this.pos < this.token.length();
        }

        @Override
        public Character next() {
            if (!this.hasNext()) {
                throw new IndexOutOfBoundsException(String.format("Reached end of StringToken %s abnormally! (pos: %d)", this.token, this.pos));
            }
            return this.token.charAt(pos++);
        }

        @Override
        public Iterator<Character> iterator() {
            return this;
        }
    
        @Override
        public Spliterator<Character> spliterator() {
            throw new UnsupportedOperationException("Cannot create a Spliterator of StringToken!");
        }
    }
}
