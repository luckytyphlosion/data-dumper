package datadumper;

import java.util.Iterator;
import java.util.Spliterator;

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
