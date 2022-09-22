import java.util.ArrayList;
import java.util.Random;

public class Adventurers extends Game {
    private String adventurerName;
    int points;
    int treasure;
    int damage;
    private ArrayList<String> adventurerObjec = new ArrayList<>();


    public String getAdventurerName() {
        return adventurerName;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }


}
