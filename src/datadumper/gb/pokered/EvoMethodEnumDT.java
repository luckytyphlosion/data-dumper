package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class EvoMethodEnumDT extends EnumDT {

	public static final String[] names = {
			"EV_ERROR", "EV_LEVEL", "EV_ITEM", "EV_TRADE"
	};

	protected SystemType systemType = SystemTypes.gb;

	public EvoMethodEnumDT(DataDumper dumper, FormatType format) {
		super(dumper, format);
		this.size = GBPrimitive.BYTE;
	}

	public EvoMethodEnumDT(DataDumper dumper, FormatType format, DataType related) {
		super(dumper, format, related);
		this.size = GBPrimitive.BYTE;
	}

	@Override
	public String[] getEnumNameArray() {
		return EvoMethodEnumDT.names;
	}

	@Override
	public int getStartingValue() {
		return 1;
	}

}
