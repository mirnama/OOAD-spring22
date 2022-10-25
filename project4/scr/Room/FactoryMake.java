package Room;

public abstract class FactoryMake {
    public static void makeTemple(Turn t) {
        t.startGame();
        t.setAdventurer();
    }
}
