public class Thief extends Adventurers {
    public Thief() {
        points=3;
        setAdventurerName("Thief");
        setDis1(getDis1());
        setDis2(getDis2());
        setTotal(rollTheDice());
    }
}
