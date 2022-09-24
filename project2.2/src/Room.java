import java.util.ArrayList;

public class Room {

    private int[] roomID = { 0, 0, 0 };
    private boolean isStair;//true if stair false if not
    private ArrayList<Creature> creaturesInRoom = new ArrayList<>();
    private ArrayList<Adventurer> adventurersInRoom = new ArrayList<>();

    // constructor that takes in roomID as 3 diff integers
    // sets room ID and the is stair boolean
    public Room(Integer i, Integer j, Integer k) {
        roomID[0] = i;
        roomID[1] = j;
        roomID[2] = k;
        if (j == 1 & k == 1) {
            this.isStair = true;
        } else {
            this.isStair = false;
        }

    }

    public ArrayList<String> getAdventuresNames() {
        ArrayList<String> aNames = new ArrayList<>();
        if (this.adventurersInRoom.size() == 0) {
            aNames.add("");
            return aNames;
        } else {
            for (int i = 0; i < this.adventurersInRoom.size(); i++) {
                Adventurer tempA = this.adventurersInRoom.get(i);

                aNames.add(tempA.getAdventurerName());
            }
            return aNames;
        }
    }

    public ArrayList<String> getCreaturesNames() {
        ArrayList<String> aNames = new ArrayList<>();
        if (this.creaturesInRoom.size() == 0) {
            aNames.add("");
            return aNames;
        } else {
            for (int i = 0; i < this.creaturesInRoom.size(); i++) {
                Creature tempA = this.creaturesInRoom.get(i);

                aNames.add(tempA.getCreatureName());
            }
            return aNames;
        }
    }

    public void addCreatureToRoom(Creature newCreature) {
        this.creaturesInRoom.add(newCreature);
    }

    public void addAdventurerToRoom(Adventurer newAdventurer) {
        this.adventurersInRoom.add(newAdventurer);
    }

    public void deleteCreatureFromRoom(Creature deleteCreature) {
        this.creaturesInRoom.remove(deleteCreature);
    }

    public void deleteAdventurerFromRoom(Adventurer deleteAdventurer) {
        this.adventurersInRoom.remove(deleteAdventurer);
    }

    public ArrayList<Creature> getCreatures() {
        return this.creaturesInRoom;
    }

    public ArrayList<Adventurer> getAdventurers() {
        return this.adventurersInRoom;
    }

    public boolean getStair() {
        return this.isStair;
    }

    public int[] getRoomID() {
        return this.roomID;
    }

    public boolean isFight() {
        if (this.adventurersInRoom.size() > 0 & this.creaturesInRoom.size() > 0) {
            return true;
        }
        return false;
    }
    

}
