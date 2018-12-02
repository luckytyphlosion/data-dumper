package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.AnonymousTemplateDT;
import datadumper.common.RadixType;
import datadumper.common.RawPrimitiveDT;
import datadumper.gb.GBPrimitive;

public class EvosEntryDT extends DataType {

    protected EvoMethodEnumDT evoMethod;
    protected AnonymousTemplateDT chosenEvoMethodTemplate;
    protected SystemType systemType = SystemTypes.gb;

    protected DataType[] evLevelTradeTemplate = new DataType[] {
            new RawPrimitiveDT(this.dumper, FormatType.INLINE, GBPrimitive.BYTE, RadixType.DECIMAL),
            new PokemonEnumDT(this.dumper, FormatType.INLINE)
    };

    protected DataType[] evItemTemplate = new DataType[] {
            new ItemEnumDT(this.dumper, FormatType.INLINE),
            new RawPrimitiveDT(this.dumper, FormatType.INLINE, GBPrimitive.BYTE, RadixType.DECIMAL),
            new PokemonEnumDT(this.dumper, FormatType.INLINE)			
    };

    public EvosEntryDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
    }

    public EvosEntryDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
    }

    @Override
    public void parseData() {
        this.evoMethod = new EvoMethodEnumDT(this.dumper, FormatType.BLOCK);
        this.evoMethod.parse();
        // EV_ITEM, todo use java Enum
        if (this.evoMethod.getValue() != 2) {
            this.chosenEvoMethodTemplate = new AnonymousTemplateDT(this.dumper, FormatType.NONE, evLevelTradeTemplate);
        } else {
            this.chosenEvoMethodTemplate = new AnonymousTemplateDT(this.dumper, FormatType.NONE, evItemTemplate);
        }
        this.chosenEvoMethodTemplate.parse();
    }

    @Override
    public String getDatatypeAsStr() {
        return evoMethod.toString() + chosenEvoMethodTemplate.toString();
    }

    @Override
    public String getBlockFormatPrefix() {
        return "";
    }

}
