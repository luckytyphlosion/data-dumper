package datadumper.gb.pokered;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;
import datadumper.SystemType;
import datadumper.SystemTypes;
import datadumper.common.EnumDT;
import datadumper.gb.GBPrimitive;

public class ItemEnumDT extends EnumDT {

    public static final String[] names = {
            "NO_ITEM",
            "MASTER_BALL",
            "ULTRA_BALL",
            "GREAT_BALL",
            "POKE_BALL",
            "TOWN_MAP",
            "BICYCLE",
            "SURFBOARD",
            "SAFARI_BALL",
            "POKEDEX",
            "MOON_STONE",
            "ANTIDOTE",
            "BURN_HEAL",
            "ICE_HEAL",
            "AWAKENING",
            "PARLYZ_HEAL",
            "FULL_RESTORE",
            "MAX_POTION",
            "HYPER_POTION",
            "SUPER_POTION",
            "POTION",
            "BOULDERBADGE",
            "CASCADEBADGE",
            "THUNDERBADGE",
            "RAINBOWBADGE",
            "SOULBADGE",
            "MARSHBADGE",
            "VOLCANOBADGE",
            "EARTHBADGE",
            "ESCAPE_ROPE",
            "REPEL",
            "OLD_AMBER",
            "FIRE_STONE",
            "THUNDER_STONE",
            "WATER_STONE",
            "HP_UP",
            "PROTEIN",
            "IRON",
            "CARBOS",
            "CALCIUM",
            "RARE_CANDY",
            "DOME_FOSSIL",
            "HELIX_FOSSIL",
            "SECRET_KEY",
            "UNUSED_ITEM",
            "BIKE_VOUCHER",
            "X_ACCURACY",
            "LEAF_STONE",
            "CARD_KEY",
            "NUGGET",
            "PP_UP_2",
            "POKE_DOLL",
            "FULL_HEAL",
            "REVIVE",
            "MAX_REVIVE",
            "GUARD_SPEC",
            "SUPER_REPEL",
            "MAX_REPEL",
            "DIRE_HIT",
            "COIN",
            "FRESH_WATER",
            "SODA_POP",
            "LEMONADE",
            "S_S_TICKET",
            "GOLD_TEETH",
            "X_ATTACK",
            "X_DEFEND",
            "X_SPEED",
            "X_SPECIAL",
            "COIN_CASE",
            "OAKS_PARCEL",
            "ITEMFINDER",
            "SILPH_SCOPE",
            "POKE_FLUTE",
            "LIFT_KEY",
            "EXP_ALL",
            "OLD_ROD",
            "GOOD_ROD",
            "SUPER_ROD",
            "PP_UP",
            "ETHER",
            "MAX_ETHER",
            "ELIXER",
            "MAX_ELIXER",
            "FLOOR_B2F",
            "FLOOR_B1F",
            "FLOOR_1F",
            "FLOOR_2F",
            "FLOOR_3F",
            "FLOOR_4F",
            "FLOOR_5F",
            "FLOOR_6F",
            "FLOOR_7F",
            "FLOOR_8F",
            "FLOOR_9F",
            "FLOOR_10F",
            "FLOOR_11F",
            "FLOOR_B4F"
    };

    protected SystemType systemType = SystemTypes.gb;

    public ItemEnumDT(DataDumper dumper, FormatType format) {
        super(dumper, format);
        this.size = GBPrimitive.BYTE;
    }

    public ItemEnumDT(DataDumper dumper, FormatType format, DataType related) {
        super(dumper, format, related);
        this.size = GBPrimitive.BYTE;
    }

    @Override
    public String[] getEnumNameArray() {
        return ItemEnumDT.names;
    }

    @Override
    public int getStartingValue() {
        return 1;
    }

}
