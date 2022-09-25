import java.util.ArrayList;
import java.util.Random;

public class Room {
    Random r = new Random();
    private int[] roomID = { 0, 0, 0 };//example of identity
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
    //returns an arrayList of all the adventures names that they were constructed with
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
    //gives an ArrayList of the creatures names
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
    //checks if there are adventures and creatures in the same room, if so it returns true, false otherwise
    public boolean isFight() {
        if (this.adventurersInRoom.size() > 0 & this.creaturesInRoom.size() > 0) {
            return true;
        }
        return false;
    }
    //returns the first creature in the creaturesInRoom ArrayList
    public Creature killCreature(){
        Creature c = creaturesInRoom.get(0);
        this.deleteCreatureFromRoom(c);
        return c;
    }
    //returns the first adventurer in the room
    public Adventurer getFirstAdventurer(){
        return this.adventurersInRoom.get(0);
    }
    // to roll the dice
    // returns the sum of two 6 sides dice rolls
    public int rollTheDice() {
        int dis1 = r.nextInt(7);
        int dis2 = r.nextInt(7);
        // System.out.println("dice 1 from rollTheDice: "+dis1);
        // System.out.println("dice 2 from rollTheDice: "+dis2);
        return dis1 + dis2;
    }
    //fights the first creature and first adventurer in room
    //returns a if the adventurer lost, c if the creature lost, and t if it was a tie
    public String fight(){
        Adventurer a = this.adventurersInRoom.get(0);
        Creature c = this.creaturesInRoom.get(0);
        int aRoll = this.rollTheDice();
        int cRoll = this.rollTheDice();
        String loser ="";
        if(aRoll> cRoll){
            //creature dead
            loser ="c";
            System.out.println(c.getCreatureName() + " was Killed by " +a.getType());
            // this.creaturesInRoom.remove(c);
        }else if(cRoll > aRoll){
            //adventurer damage
            loser = "a";
            // a.takeDamage();
            System.out.println(a.getType() + " was hurt by "+ c.getCreatureName());
        }else if(aRoll == cRoll){
            //tie
            loser = "t";
            System.out.println(a.getType() + " and "+ c.getCreatureName()+ " Tied");
        }
        return loser;
    }
    

}
