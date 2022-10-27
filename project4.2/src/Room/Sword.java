package Room;

public class Sword extends Treasures{


    public Sword(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type = TreasureType.SWORD;
    }
}
