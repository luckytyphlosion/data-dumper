package datadumper.common;

import java.util.ArrayList;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.GenericDataType;

public abstract class ListDT extends GenericDataType {

	protected ArrayList<DataType> dataTypeList;

	public ListDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		this.dataTypeList = new ArrayList<DataType>();
	}

	@Override
	public void parseData() {
		while (loopCondition()) {
			DataType dataType = this.related.createCopy();
			dataTypeList.add(dataType);
			dataType.parse();
		}
	}

	public abstract boolean loopCondition();

	@Override
	public String getDatatypeAsStr() {
		String output = "";
		for (DataType dataType : dataTypeList) {
			String dataTypeOutput = dataType.toString();
			output += dataTypeOutput;
		}
		output += this.getPostLoopDatatypesAsStr();
		return output;
	}

	public String getPostLoopDatatypesAsStr() {
		return "";
	}

	@Override
	public String getBlockFormatPrefix() {
		return "";
	}

}
