package datadumper.gba.bn6f;

import datadumper.ConstantType;

public enum BattleObjSetupTypeConst implements ConstantType {
    BATTLE_OBJECT_TYPE_PLAYER(0x00),
    BATTLE_OBJECT_TYPE_LINK_OPPONENT(0x01),
    BATTLE_OBJECT_TYPE_RED_SIDE(0x10),
    BATTLE_OBJECT_TYPE_BLUE_SIDE(0x11),
    BATTLE_OBJECT_TYPE_MYSTERY_DATA(0x20),
    BATTLE_OBJECT_TYPE_ROCK(0x30),
    BATTLE_OBJECT_TYPE_FLAG(0x70),
    BATTLE_OBJECT_TYPE_ROCK_CUBE(0x80),
    BATTLE_OBJECT_TYPE_GUARDIAN(0x90),
    BATTLE_OBJECT_TYPE_METAL_CUBE(0xa0);
    
    private long value;

    BattleObjSetupTypeConst(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }
    
    public Enum<?> getEnum() {
        return this;
    }
}