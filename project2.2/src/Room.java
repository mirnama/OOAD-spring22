import java.util.ArrayList;


public class Room extends Game{

    private final ArrayList<Integer> roomID = new ArrayList<>();
    private final boolean isStair;
//    ArrayList<Creature> creaturesInRoom;
    ArrayList<Adventurers> adventurersInRoom;

    // constructor that takes in roomID as 3 diff integers
    // sets room ID and the is stair boolean
    public Room(Integer i, Integer j, Integer k) {
        this.roomID.add(i);
        this.roomID.add(j);
        this.roomID.add(k);
        this.isStair = j == 1 & k == 1;

    }
    

//    public void addCreatureToRoom(Creature newCreature) {
//        this.creaturesInRoom.add(newCreature);
//    }

    public void addAdventurerToRoom(Adventurers newAdventurer) {
        this.adventurersInRoom.add(newAdventurer);
    }

//    public void deleteCreatureFromRoom(Creature deleteCreature) {
//        this.creaturesInRoom.remove(deleteCreature);
//    }

    public void deleteAdventurerFromRoom(Adventurers deleteAdventurer) {
        this.adventurersInRoom.remove(deleteAdventurer);
    }
//    public ArrayList<Creature> getCreatures(){
//        return this.creaturesInRoom;
//    }
    public ArrayList<Adventurers> getAdventurers(){
        return this.adventurersInRoom;
    }

    public boolean getStair() {
        return this.isStair;
    }

    public ArrayList<Integer> getRoomID() {
        return this.roomID;
    }

    
}
