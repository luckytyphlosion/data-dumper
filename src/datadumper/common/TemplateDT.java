package datadumper.common;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public abstract class TemplateDT extends DataType {

	protected DataType[] dataTypeTemplate;

	public TemplateDT(DataDumper dumper, FormatType format) {
		super(dumper, format);
	}

	public TemplateDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		
	}

	@Override
	public void parseData() {
		this.dataTypeTemplate = this.getDataTypeTemplate();
		for (DataType dataType : this.dataTypeTemplate) {
			dataType.parse();
		}
	}

	@Override
	public String getDatatypeAsStr() {
		String output = "";
		for (DataType dataType : this.dataTypeTemplate) {
			output += dataType.toString();
		}
		return output;
	}

	@Override
	public String getBlockFormatPrefix() {
		return "";
	}
	
	public abstract DataType[] getDataTypeTemplate();

}
