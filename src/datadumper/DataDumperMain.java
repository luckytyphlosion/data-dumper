package datadumper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datadumper.common.AnonymousTemplateDT;
import datadumper.common.EnumTerminatedListDT;
import datadumper.common.RadixType;
//import datadumper.common.RawPrimitiveDT;
import datadumper.common.SentinelTerminatedListDT;
import datadumper.gb.GBPointerDT;
import datadumper.gb.GBPrimitive;
import datadumper.gb.pokered.EvosEntryDT;
import datadumper.gb.pokered.LevelMoveTemplateDT;
import datadumper.gb.pokered.PokemonEnumDT;
//import datadumper.gba.GBAPointerDT;
//import datadumper.gba.GBAPrimitive;
import datadumper.tests.CrystalTrainerPartiesTest;

public class DataDumperMain {

    /*public class DataDumperArgs {
		public final String inputFileName;
		public final SystemType systemType;
		public final DataTypeAddressLabel[] inputDataTypes;

		public DataDumperArgs(String inputFileName, SystemType systemType, DataTypeAddressLabel[] inputDataTypes) {
			this.inputFileName = inputFileName;
			this.systemType = systemType;
			this.inputDataTypes = inputDataTypes;
		}

		public class DataTypeAddressLabel {
			public final DataType dataType;
			public final long address;
			public final String label;

			public DataTypeAddressLabel(DataType dataType, long address, String label) {
				this.dataType = dataType;
				this.address = address;
				this.label = label;
			}
		}
	}

	public static final DataDumperArgs dumperArgs = new DataDumperArgs("blue_tests.gb", SystemType.gb, new DataTypeAddressLabel[] {
			new DataTypeAddressLabel(new EnumTerminatedList())
	}
			);*/

    public static void main(String[] args) {
        CrystalTrainerPartiesTest.test();
        //System.out.println(output);
    }
}
