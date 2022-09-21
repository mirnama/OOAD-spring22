import java.util.ArrayList;
import java.util.Random;

public class Adventurers extends Game {
    private String adventurerName;
    int points;
    private ArrayList<String> adventurerObjec = new ArrayList<>();
//    Random r = new Random();
    private int dis1,dis2;

    public int getDis1() {
        return dis1;
    }


    public int getDis2() {
        return dis2;
    }


    public String getAdventurerName() {
        return adventurerName;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }


}
