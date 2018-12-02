package datadumper;

import datadumper.gb.GBSystemType;
import datadumper.gba.GBASystemType;

public class SystemTypes {

	public static final GBSystemType gb = new GBSystemType();
	public static final GBASystemType gbaFlavour0 = new GBASystemType(GBASystemType.FLAVOUR_0);
	public static final GBASystemType gbaFlavour1 = new GBASystemType(GBASystemType.FLAVOUR_1);

	private SystemTypes() {

	}
	
}
