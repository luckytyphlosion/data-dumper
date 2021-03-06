package datadumper.gb.pokecrystal;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.common.AnonCommandDT;
import datadumper.common.AnonTemplateDT;
import datadumper.common.DecByteDT;
import datadumper.common.RawPrimitiveDT;
//import datadumper.common.StringDT;
import datadumper.common.TemplateDT;
import datadumper.common.SentinelListDT;
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
            new SentinelListDT(
                dumper, FormatType.NONE, "1%02x", 0x50, FormatType.INLINE,
                new RawPrimitiveDT(
                    dumper, FormatType.BLOCK, "1%02x"
                )
            ), // TODO make String class
         
            new AnonCommandDT(
                dumper, FormatType.NONE,
                new TrainerTypeEnumDT(dumper, FormatType.INLINE), 
                new DataType[] {
                    new SentinelListDT(
                        dumper, FormatType.NONE, "1%02x", 0xff, FormatType.BLOCK, 
                        new AnonTemplateDT(dumper, FormatType.NONE,
                            new DataType[] {
                                new DecByteDT(dumper, FormatType.BLOCK),
                                new PokemonEnumDT(dumper, FormatType.INLINE)
                            }
                        )
                    ),
                    new SentinelListDT(
                        dumper, FormatType.NONE, "1%02x", 0xff, FormatType.BLOCK, 
                        new AnonTemplateDT(dumper, FormatType.NONE,
                            new DataType[] {
                                new DecByteDT(dumper, FormatType.BLOCK),
                                new PokemonEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE)
                            }
                        )
                    ),
                    new SentinelListDT(dumper, FormatType.NONE, "1%02x", 0xff, FormatType.BLOCK, 
                        new AnonTemplateDT(dumper, FormatType.NONE,
                            new DataType[] {
                                new DecByteDT(dumper, FormatType.BLOCK),
                                new PokemonEnumDT(dumper, FormatType.INLINE),
                                new ItemEnumDT(dumper, FormatType.INLINE)
                            }
                        )
                    ),
                    new SentinelListDT(dumper, FormatType.NONE, "1%02x", 0xff, FormatType.BLOCK, 
                        new AnonTemplateDT(dumper, FormatType.NONE,
                            new DataType[] {
                                new DecByteDT(dumper, FormatType.BLOCK),
                                new PokemonEnumDT(dumper, FormatType.INLINE),
                                new ItemEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE),
                                new MoveEnumDT(dumper, FormatType.INLINE)
                            }
                        )
                    )
                }
            )
        };
    }

}
