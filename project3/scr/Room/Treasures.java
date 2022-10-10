package Room;

import Logger.Logger;

public class Treasures implements Logger {
    String treaguerType;
    Room location;

    public Treasures(String treaguerType, Room location, Integer trCount, TreasureType type) {
        this.treaguerType = treaguerType;
        this.location = location;
        this.trCount = trCount;
        this.type = type;
    }

    Integer trCount;
    TreasureType type;
}

enum TreasureType{
    SWORD,
    GEM,
    ARMOR,
    PORTAL,
    TRAP,
    POTION;

    private TreasureType() {
    }
}
