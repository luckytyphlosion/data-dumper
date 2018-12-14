package datadumper.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemTypes;
import datadumper.common.AnonTemplateDT;
import datadumper.common.EnumListDT;
import datadumper.common.SentinelListDT;
import datadumper.gb.GBPointerDT;
import datadumper.gb.pokered.EvosEntryDT;
import datadumper.gb.pokered.LevelMoveTemplateDT;
import datadumper.gb.pokered.PokemonEnumDT;

public class RedEvosMovesTest {
    public static void test() {
        String inputFileName = "blue_tests.gb";
        DataDumper dumper = new DataDumper(inputFileName, "r", SystemTypes.gb);
        DataType dataType = new EnumListDT(dumper, FormatType.NONE, PokemonEnumDT.class,
            new GBPointerDT(dumper, FormatType.BLOCK, "%eEvosMoves",
                new AnonTemplateDT(dumper, FormatType.NONE, new DataType[] {
                    new SentinelListDT(dumper, FormatType.NONE, "1%d", 0, FormatType.BLOCK, 
                        new EvosEntryDT(dumper, FormatType.NONE)),
                    new SentinelListDT(dumper, FormatType.NONE, "1%d", 0, FormatType.BLOCK,
                        new LevelMoveTemplateDT(dumper, FormatType.NONE))}
                )
            )
        );
        String output = "";
        dumper.addDataTypeToQueue(dataType, 0x3B05CL, "EvosMovesPointerTable");
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
