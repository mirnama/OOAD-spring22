public class Brawler extends Adventurers{
    public Brawler() {
        setAdventurerName("Brawler");
//        getTotal();
        points=3;
        damage=0;
//        setDis1(getDis1());
//        setDis2(getDis2());
        setTotal(rollTheDice());

    }
}
