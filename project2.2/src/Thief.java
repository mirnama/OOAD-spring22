public class Thief extends Adventurers {
    public Thief() {
        setPoints(3);
        damage=0;
        setAdventurerName("Thief");
        setTotal(rollTheDice());
    }
}
