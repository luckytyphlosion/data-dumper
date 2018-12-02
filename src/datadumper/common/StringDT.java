package datadumper.common;

import java.util.HashMap;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class StringDT extends DataType {

    public StringDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public StringDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {

    }

    //public abstract HashMap<int[], String> getCharmap();

    @Override
    public String getDatatypeAsStr() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getBlockFormatPrefix() {
        // TODO Auto-generated method stub
        return null;
    }

}
