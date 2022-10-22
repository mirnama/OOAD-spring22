package Room;

public class Portal extends Treasures{
    public Portal(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type = TreasureType.PORTAL;
    }
}
