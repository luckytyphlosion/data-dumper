package datadumper;

public class DataDumperMain {

	public static void main(String[] args) {
        String inputFileName = "bn6f.gba";
        DataDumper dumper = new DataDumper(inputFileName, "r");
        DataType dataType = new GBAPointerDT(dumper, FormatType.BLOCK, new GBAByteDT(dumper, FormatType.BLOCK));
        dumper.addDataTypeToParse(dataType, 0x30FCL, "unk_80030fc");
        dumper.parse();
        System.out.println(dumper.generateOutput());
	}
}
