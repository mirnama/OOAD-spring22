package Room;

public class Trap extends Treasures{
    public Trap(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type = TreasureType.TRAP;
    }
}
