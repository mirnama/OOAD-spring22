public class Thief extends Adventurers {
    public Thief() {
        points=3;
        damage=0;
        setAdventurerName("Thief");
        setTotal(rollTheDice());
    }
}
