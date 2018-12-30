package datadumper.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemTypes;
import datadumper.common.ParsedAddressListDT;
import datadumper.common.SentinelListDT;
import datadumper.gba.bn6f.BattleObjectSetupDT;
import datadumper.gba.bn6f.BattleSettingsDT;

public class BN6FBattleSettingsTest {
    public static void test() {
        String inputFileName = "bn6f.gba";
        DataDumper dumper = new DataDumper(inputFileName, "r", SystemTypes.gbaFlavour1);
        DataType dataType1 = new SentinelListDT(dumper, FormatType.NONE, "4%02x", 0xff, FormatType.BLOCK,
            new BattleSettingsDT(dumper, FormatType.NONE)
        );
        DataType dataType2 = new SentinelListDT(dumper, FormatType.NONE, "1%02x", 0xff, FormatType.BLOCK,
            new BattleSettingsDT(dumper, FormatType.NONE)
        );
        DataType dataType3 = new ParsedAddressListDT(dumper, FormatType.NONE,
            new SentinelListDT(dumper, FormatType.NONE, "1%02x", 0xf0, FormatType.BLOCK, 
                new BattleObjectSetupDT(dumper, FormatType.NONE)
            )
        );
        String output = "";
        dumper.addDataTypeToQueue(dataType1, 0xaee70, "BattleSettings0", "0_");
        dumper.addDataTypeToQueue(dataType2, 0xb0d88, "BattleSettings1", "1_");
        dumper.addDataTypeToQueue(dataType3, 0xb199b, "UnusedObjectSetupPointers");
        dumper.parse();
        output = dumper.generateOutput();
        File outputFile = new File("output/bn6f_battle_settings.txt");
        outputFile.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }
}
