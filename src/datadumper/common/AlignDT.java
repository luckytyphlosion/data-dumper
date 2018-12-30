package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class AlignDT extends DataType {

    public AlignDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    @Override
    public void parseData() {
        
    }

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
