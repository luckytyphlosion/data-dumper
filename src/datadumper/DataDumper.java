
package datadumper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class DataDumper {
    private DataDumperInputFile inputFile;
    private ArrayList<QueuedDataType> dataTypeQueue;
    private HashSet<Long> parsedTopLevelAddresses;
    private SystemType systemType;
    private BufferedWriter logFile;
    private ArrayList<String> enumLabelList;
    private ArrayList<Integer> loopIndicesList;
    private QueuedDataType currentQueuedDataType;

    public DataDumper(String name, String mode, SystemType systemType) {
        this.inputFile = new DataDumperInputFile(name, mode);
        this.dataTypeQueue = new ArrayList<QueuedDataType>();
        this.parsedTopLevelAddresses = new HashSet<Long>();
        this.systemType = systemType;
        try {
            File outputFile = new File("output/parse_log.txt");
            outputFile.getParentFile().mkdirs();
            this.logFile = new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.enumLabelList = new ArrayList<String>();
        this.loopIndicesList = new ArrayList<Integer>();
        this.currentQueuedDataType = new QueuedDataType(DataType.nullDataType, -1, "Error");
    }

    public void addDataTypeToQueue(DataType dataType, long address, String label) {
        addDataTypeToQueue(dataType, address, label, "Error");
    }

    public void addDataTypeToQueue(DataType dataType, long address, String label, String parentBaseLabel) {
        dataType.setLabel(label);
        //System.out.println(String.format("%x", address));
        this.dataTypeQueue.add(new QueuedDataType(dataType, address, parentBaseLabel));
    }

    public DataDumperInputFile getInputFile() {
        return this.inputFile;
    }

    public SystemType getSystemType() {
        return this.systemType;
    }

    public ArrayList<QueuedDataType> getDataTypeQueue() {
        return this.dataTypeQueue;
    }

    public void allocateEnumLabel() {
        this.enumLabelList.add("");
    }

    public void deallocateEnumLabel() {
        this.enumLabelList.remove(this.enumLabelList.size() - 1);
    }

    public void setCurrentEnumLabel(String enumLabel) {
        this.enumLabelList.set(this.enumLabelList.size() - 1, enumLabel);
    }

    public String getCurrentEnumLabel() {
        return this.enumLabelList.get(this.enumLabelList.size() - 1);
    }

    public void allocateLoopIndex(int loopIndex) {
        this.loopIndicesList.add(loopIndex);
    }

    public void deallocateLoopIndex() {
        this.loopIndicesList.remove(this.loopIndicesList.size() - 1);
    }

    public void setCurrentLoopIndex(int loopIndex) {
        this.loopIndicesList.set(this.loopIndicesList.size() - 1, loopIndex);
    }

    public int getCurrentLoopIndex() {
        return this.loopIndicesList.get(this.loopIndicesList.size() - 1);
    }

    public BufferedWriter getLogFile() {
        return this.logFile;
    }

    public void parse() {
        // With a for each loop, a ConcurrentModificationException is thrown for each iteration if a new DataType is added.
        // Since the only modification operation allowed is add, an indexed for-loop is used with size() as upper bound
        // to account for new elements added
        // ListIterator inserts the element in-between the current and next element, which is not wanted.
        for (int i = 0; i < dataTypeQueue.size(); i++) {
            this.currentQueuedDataType = dataTypeQueue.get(i);
            if (this.parsedTopLevelAddresses.contains(this.currentQueuedDataType.address)) {
                try {
                    this.getLogFile().write(String.format("Did not parse %s at %x (already exists)\n", this.getClass().getName(), this.currentQueuedDataType.address));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                this.inputFile.seek(this.currentQueuedDataType.address);
                this.currentQueuedDataType.dataType.setAddressFromInputFilePos();
                continue;
            }
            
            this.parsedTopLevelAddresses.add(this.currentQueuedDataType.address);
            this.inputFile.seek(this.currentQueuedDataType.address);
            this.currentQueuedDataType.dataType.parse();
            this.currentQueuedDataType.setEndAddress(this.inputFile.getFilePointer());
            this.currentQueuedDataType.setParsedTrue();
        }
    }
    
    public String getParentBaseLabel() {
        return this.currentQueuedDataType.parentBaseLabel;
    }

    public String generateOutput() {
        String output = "";
        try {
            this.logFile.write("====================================\ndataTypeQueue:\n");
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
        
        for (QueuedDataType queuedDataType : this.dataTypeQueue) {
            try {
                this.logFile.write(String.format("%s at %x\n",  queuedDataType.dataType.getClass().getName(), queuedDataType.dataType.getLoadAddress()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            this.logFile.write("====================================\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<QueuedDataType> orderedDataTypeQueue = new ArrayList<QueuedDataType>(this.dataTypeQueue);
        Collections.sort(orderedDataTypeQueue);
        
        long prevEndAddress = -1;

        for (QueuedDataType queuedDataType : orderedDataTypeQueue) {
            if (!queuedDataType.isParsed()) {
                continue;
            }
            if (prevEndAddress != -1 && prevEndAddress != queuedDataType.address) {
                output += "\n" + this.systemType.generateUnparsedMemoryRangeOutput(prevEndAddress, queuedDataType.address);
            }
            try {
                this.logFile.write(String.format("Parse top level: %s at %x\n",  queuedDataType.dataType.getClass().getName(), queuedDataType.dataType.getLoadAddress()));
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
            output += queuedDataType.dataType.toString();
            prevEndAddress = queuedDataType.getEndAddress();
        }
        try {
            this.logFile.close();
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
        return output + "\n" + this.systemType.generateAddressCommentFromLoadAddress(this.inputFile.getFilePointer()) + "\n";
    }

    /**
     * Converts a "short" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static short swapShort(final short value) {
        return (short) ( ( ( ( value >> 0 ) & 0xff ) << 8 ) +
                ( ( ( value >> 8 ) & 0xff ) << 0 ) );
    }

    /**
     * Converts a "int" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static int swapInteger(final int value) {
        return
                ( ( ( value >> 0 ) & 0xff ) << 24 ) +
                ( ( ( value >> 8 ) & 0xff ) << 16 ) +
                ( ( ( value >> 16 ) & 0xff ) << 8 ) +
                ( ( ( value >> 24 ) & 0xff ) << 0 );
    }

    /**
     * Converts a "long" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    public static long swapLong(final long value) {
        return
                ( ( ( value >> 0 ) & 0xff ) << 56 ) +
                ( ( ( value >> 8 ) & 0xff ) << 48 ) +
                ( ( ( value >> 16 ) & 0xff ) << 40 ) +
                ( ( ( value >> 24 ) & 0xff ) << 32 ) +
                ( ( ( value >> 32 ) & 0xff ) << 24 ) +
                ( ( ( value >> 40 ) & 0xff ) << 16 ) +
                ( ( ( value >> 48 ) & 0xff ) << 8 ) +
                ( ( ( value >> 56 ) & 0xff ) << 0 );
    }

    /**
     * Converts a value of arbitrary byte length (limited to long size) between endian systems.
     * @param value value to convert.
     * @param byteSize number of bytes required to represent value.
     * @return the converted value
     */
    public static long swapX(final long value, final int byteSize) {
        long newValue = 0;
        for (int i = 0, j = byteSize - 1; i < byteSize; i++, j--) {
            long tempValue = (((value >> (i * 8)) & 0xff) << (j * 8));
            newValue |= tempValue;
        }
        return newValue;
    }

    // unused but may as well keep
    public static long pow(long a, int b)
    {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if ((b & 1) == 0) {
            return DataDumper.pow(a*a, b/2); // even: a=(a^2)^b/2
        } else {
            return a * pow(a*a, b/2); // odd: a=a*(a^2)^b/2
        }
    }
}
