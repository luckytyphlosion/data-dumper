package datadumper.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemTypes;
import datadumper.common.AnonymousTemplateDT;
import datadumper.common.EnumTerminatedListDT;
import datadumper.common.SentinelTerminatedListDT;
import datadumper.gb.GBPointerDT;
import datadumper.gb.pokered.EvosEntryDT;
import datadumper.gb.pokered.LevelMoveTemplateDT;
import datadumper.gb.pokered.PokemonEnumDT;

public class RedEvosMovesTest {
    public static void test() {
        String inputFileName = "blue_tests.gb";
        DataDumper dumper = new DataDumper(inputFileName, "r", SystemTypes.gb);
        DataType dataType = new EnumTerminatedListDT(dumper, FormatType.NONE, PokemonEnumDT.class,
            new GBPointerDT(dumper, FormatType.BLOCK,
                new AnonymousTemplateDT(dumper, FormatType.NONE, new DataType[] {
                    new SentinelTerminatedListDT(dumper, FormatType.NONE, "1%d", 0, FormatType.BLOCK, 
                        new EvosEntryDT(dumper, FormatType.NONE)),
                    new SentinelTerminatedListDT(dumper, FormatType.NONE, "1%d", 0, FormatType.BLOCK,
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
    }
}
