package Room;

public class Gem extends Treasures{
    public Gem(String treaguerType, Room location, Integer trCount, TreasureType type) {
        super(treaguerType, location, trCount, type);
        type= TreasureType.GEM;
    }
}
