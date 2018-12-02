package datadumper.gb.pokecrystal;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.AnonymousImmediateCommandDT;
import datadumper.common.AnonymousTemplateDT;
import datadumper.common.DecByteDT;
import datadumper.common.RadixType;
import datadumper.common.RawPrimitiveDT;
//import datadumper.common.StringDT;
import datadumper.common.TemplateDT;
import datadumper.gb.GBPrimitive;
import datadumper.common.SentinelTerminatedListDT;
//import datadumper

public class TrainerPartyDT extends TemplateDT {

    public TrainerPartyDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public TrainerPartyDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public DataType[] getDataTypeTemplate() {
        return new DataType[] {
                new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.HEXADECIMAL, 0x50, FormatType.INLINE, new RawPrimitiveDT(dumper, FormatType.BLOCK, GBPrimitive.BYTE, RadixType.HEXADECIMAL)), // todo make String class
                new AnonymousImmediateCommandDT(dumper, FormatType.NONE, new TrainerTypeEnumDT(dumper, FormatType.INLINE), 
                    new DataType[] {
                        new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.HEXADECIMAL, 0xff, FormatType.BLOCK, 
                            new AnonymousTemplateDT(dumper, FormatType.NONE,
                                new DataType[] {
                                    new DecByteDT(dumper, FormatType.BLOCK),
                                    new PokemonEnumDT(dumper, FormatType.INLINE)
                                })),
                        new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.HEXADECIMAL, 0xff, FormatType.BLOCK, 
                            new AnonymousTemplateDT(dumper, FormatType.NONE,
                                new DataType[] {
                                    new DecByteDT(dumper, FormatType.BLOCK),
                                    new PokemonEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE)
                                })),
                        new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.HEXADECIMAL, 0xff, FormatType.BLOCK, 
                            new AnonymousTemplateDT(dumper, FormatType.NONE,
                                new DataType[] {
                                    new DecByteDT(dumper, FormatType.BLOCK),
                                    new PokemonEnumDT(dumper, FormatType.INLINE),
                                    new ItemEnumDT(dumper, FormatType.INLINE)
                                })),
                        new SentinelTerminatedListDT(dumper, FormatType.NONE, GBPrimitive.BYTE, RadixType.HEXADECIMAL, 0xff, FormatType.BLOCK, 
                            new AnonymousTemplateDT(dumper, FormatType.NONE,
                                new DataType[] {
                                    new DecByteDT(dumper, FormatType.BLOCK),
                                    new PokemonEnumDT(dumper, FormatType.INLINE),
                                    new ItemEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE),
                                    new MoveEnumDT(dumper, FormatType.INLINE)
                                }))
                    })};

    }

}
