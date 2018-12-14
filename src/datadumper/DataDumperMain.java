package datadumper;

import datadumper.tests.*;

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
        RedEvosMovesTest.test();
        CrystalTrainerPartiesTest.test();
        BN6FBattleSettingsTest.test();
    }
}
