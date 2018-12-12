package datadumper.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemTypes;
import datadumper.common.ParsedAddressTerminatedListDT;
import datadumper.gb.GBPointerDT;
import datadumper.gb.pokecrystal.TrainerPartyDT;

public class BN6FBattleSettingsTest {
    public static void test() {
        String inputFileName = "bn6f.gba";
        DataDumper dumper = new DataDumper(inputFileName, "r", SystemTypes.gbaFlavour1);
        DataType dataType = new ParsedAddressTerminatedListDT(dumper, FormatType.NONE,
            new GBPointerDT(dumper, FormatType.BLOCK,
                new ParsedAddressTerminatedListDT(dumper, FormatType.NONE, new TrainerPartyDT(dumper, FormatType.NONE))
            )
        );
        String output = "";
        dumper.addDataTypeToParse(dataType, 0x39999, "TrainerGroups");
        dumper.parse();
        output = dumper.generateOutput();
        File outputFile = new File("output/crystal_trainers.txt");
        outputFile.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }
}
