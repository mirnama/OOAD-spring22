package Room;

public class Potion extends Treasures{
    public Potion(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type = TreasureType.POTION;
    }
}
