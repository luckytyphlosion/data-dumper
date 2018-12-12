package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class AnonTemplateDT extends TemplateDT {

    protected DataType[] tempTemplate;

    public AnonTemplateDT(DataDumper dumper, FormatType format, DataType[] tempTemplate) {
        super(dumper, format);
        this.tempTemplate = tempTemplate;
    }

    public AnonTemplateDT(DataDumper dumper, FormatType format, DataType related, DataType[] tempTemplate) {
        super(dumper, format, related);
        this.tempTemplate = tempTemplate;
    }

    public DataType createCopy() {
        DataType[] newTemplate = new DataType[this.tempTemplate.length];
        for (int i = 0; i < newTemplate.length; i++) {
            newTemplate[i] = this.tempTemplate[i].createCopy();
        }

        return new AnonTemplateDT(this.dumper, this.format, this.related.createCopy(), newTemplate);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return this.tempTemplate;
    }

}
