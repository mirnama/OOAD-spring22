public class Sneaker extends Adventurers{
    public Sneaker() {
        points=3;
        setAdventurerName("Sneaker");
        setDis1(getDis1());
        setDis2(getDis2());
        setTotal(rollTheDice());
    }
}
