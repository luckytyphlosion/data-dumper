package datadumper;

public class DataDumperMain {

	public static void main(String[] args) {
        String inputFileName = "bn6f.gba";
        DataDumper dumper = new DataDumper(inputFileName, "r");
        dumper.addDataTypeToParse(new GBAPointerDT(dumper, FormatType.BLOCK, new GBAByteDT(dumper, FormatType.BLOCK)), new GBAAddress(0x80030FCL), "unk_80030fc");
        dumper.parse();
        System.out.println(dumper.generateOutput());
	}
}
