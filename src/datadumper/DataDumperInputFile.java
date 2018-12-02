package datadumper;

import java.io.DataInput;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DataDumperInputFile implements DataInput {

    private RandomAccessFile inputFile;

    public DataDumperInputFile(String name, String mode) {
        try {
            this.inputFile = new RandomAccessFile(name, mode);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void seek(long loadAddress) {
        try {
            this.inputFile.seek(loadAddress);    		
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean readBoolean() {
        try {
            return this.inputFile.readBoolean();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte readByte() {
        try {
            return this.inputFile.readByte();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public char readChar() {
        try {
            return this.inputFile.readChar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double readDouble() {
        try {
            return this.inputFile.readDouble();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float readFloat() {
        try {
            return this.inputFile.readFloat();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFully(byte[] b) {
        try {
            this.inputFile.readFully(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFully(byte[] b, int off, int len) {
        try {
            this.inputFile.readFully(b, off, len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readInt() {
        try {
            return this.inputFile.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readLine() {
        try {
            return this.inputFile.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long readLong() {
        try {
            return this.inputFile.readLong();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public short readShort() {
        try {
            return this.inputFile.readShort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readUTF() {
        try {
            return this.inputFile.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readUnsignedByte() {
        try {
            return this.inputFile.readUnsignedByte();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readUnsignedShort() {
        try {
            return this.inputFile.readUnsignedShort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int skipBytes(int n) {
        try {
            return this.inputFile.skipBytes(n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int read() {
        int value;

        try {
            value = this.inputFile.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (value == -1) {
            throw new RuntimeException(new EOFException("Reached end of file in DataDumperInputFile.read()!"));
        }
        return value;
    }

    public long getFilePointer() {
        try {
            return this.inputFile.getFilePointer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
