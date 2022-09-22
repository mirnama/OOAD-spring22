import java.util.ArrayList;
import java.util.Random;

public class Adventurers extends Game {
    private String adventurerName;
    int points;
    int treasure;
    int damage;
    ArrayList<Integer> currPosition;
    private final ArrayList<String> adventurerObjec = new ArrayList<>();
    public void setCurrPosition(ArrayList<Integer> newCurr) {
        currPosition = newCurr;
    }
    public ArrayList<Integer> getCurrentPosition() {
        return currPosition;
    }

    public String getAdventurerName() {
        return adventurerName;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }



}
