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
// from the class code example
// I do this to avoid parsing output from getclass() and to be clear about what object I'm talking to
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
