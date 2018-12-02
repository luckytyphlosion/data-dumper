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
        String inputFileName = "blue_tests.gb";
        DataDumper dumper = new DataDumper(inputFileName, "r", SystemTypes.gb);
        DataType dataType = new EnumTerminatedListDT(
                dumper, FormatType.NONE, PokemonEnumDT.class, new GBPointerDT(
                        dumper, FormatType.BLOCK,
                        new AnonymousTemplateDT(dumper, FormatType.NONE, new DataType[] {
                                new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.DECIMAL, 0, FormatType.BLOCK, 
                                        new EvosEntryDT(dumper, FormatType.NONE)),
                                new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.DECIMAL, 0, FormatType.BLOCK,
                                        new LevelMoveTemplateDT(dumper, FormatType.NONE))}
                                )
                        )
                );
        String output = "";
        dumper.addDataTypeToParse(dataType, 0x3B05CL, "EvosMovesPointerTable");
        dumper.parse();
        output = dumper.generateOutput();
        File outputFile = new File("output/output.txt");
        outputFile.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
        //System.out.println(output);
    }
}
