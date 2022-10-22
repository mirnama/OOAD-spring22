package Room;

public class Armor extends Treasures{
    public Armor(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type = TreasureType.ARMOR;
    }
}
