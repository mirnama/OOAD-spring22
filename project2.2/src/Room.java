import java.util.ArrayList;


public class Room {

    private ArrayList<Integer> roomID = new ArrayList<>();
    private boolean isStair;
    ArrayList<Creature> creaturesInRoom;
    ArrayList<Adventurer> adventurersInRoom;

    // constructor that takes in roomID as 3 diff integers
    // sets room ID and the is stair boolean
    public Room(Integer i, Integer j, Integer k) {
        this.roomID.add(i);
        this.roomID.add(j);
        this.roomID.add(k);
        if (j == 1 & k == 1) {
            this.isStair = true;
        } else {
            this.isStair = false;
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
    public ArrayList<Creature> getCreatures(){
        return this.creaturesInRoom;
    }
    public ArrayList<Adventurer> getAdventurers(){
        return this.adventurersInRoom;
    }

    public boolean getStair() {
        return this.isStair;
    }

    public ArrayList<Integer> getRoomID() {
        return this.roomID;
    }

    
}