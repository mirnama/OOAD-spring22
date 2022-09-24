import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Turn extends Main {
    ArrayList<Room> Temple = new ArrayList<Room>();
    ArrayList<Creature> Creatures = new ArrayList<Creature>();
    ArrayList<Adventurer> Adventurers = new ArrayList<Adventurer>();

    Random r = new Random();

    // Takes in a room Id and finds it in the temple
    // returns a room object or null
    public Room getRoomFromTemple(int[] id) {
        for (int i = 0; i < this.Temple.size(); i++) {
            Room r = this.Temple.get(i);
            // int[] currRoomId = r.getRoomID();
            // System.out.println("GetRoomFromTemple "+Arrays.toString(r.getRoomID()) +"ID
            // "+ Arrays.toString(id));
            // if (currRoomId[0] == id[0] & currRoomId[1] == id[1] & currRoomId[2] == id[2])
            // {
            // // System.out.println("found");
            // return r;
            // }
            if (Arrays.equals(r.getRoomID(), id)) {
                return r;
            }
        }
        return null;
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

    // returns the string of what won/if there was a tie
    public String fight() {
        int aDice = this.rollTheDice();
        int cDice = this.rollTheDice();
        if (aDice > cDice) {
            return ("Adventurer");
        } else if (cDice > aDice) {
            return ("Creature");
        } else {
            return ("Tie");
        }
    }

    // Initializes the temple
    // spawns in adventures and 4 of each type of creature
    // add all to a masterList that is stored in Main
    public void startGame() {

        // start room is NOT a room in temple
        Room startRoom = new Room(0, 1, 1);
        int[] startPos = { 0, 1, 1 };
        // adventueres
        Brawler brawler = new Brawler("B", "Brawler", startPos);
        Sneaker sneaker = new Sneaker("S", "Sneaker", startPos);
        Thief thief = new Thief("T", "Thief", startPos);
        Runner runner = new Runner("R", "Runner", startPos);
        this.Adventurers.add(brawler);
        this.Adventurers.add(sneaker);
        this.Adventurers.add(thief);
        this.Adventurers.add(runner);
        startRoom.addAdventurerToRoom(brawler);
        startRoom.addAdventurerToRoom(sneaker);
        startRoom.addAdventurerToRoom(thief);
        startRoom.addAdventurerToRoom(runner);
        this.Temple.add(startRoom);
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    this.Temple.add(new Room(i, j, k));
                    // System.out.println("("+i+j+k+")");
                }
            }
        }
        // not passing the temple array correctly
        // spawn Orbiters
        for (int i = 0; i < 4; i++) {
            // Room randR = this.Temple.get(r.nextInt(this.Temple.size()));
            // boolean outerRoom = true;
            int randRoomIndex = r.nextInt(this.Temple.size());
            // System.out.print("Orbiters"+randRoomIndex);
            Room randR = this.Temple.get(randRoomIndex);
            // System.out.print(Arrays.toString(randR.getRoomID()));
            // System.out.println("orbiter thing"+randR.getStair());
            if (randR.getStair() & randRoomIndex != this.getTempleSize()) {
                randRoomIndex++;
                randR = this.Temple.get(randRoomIndex);
            }
            // System.out.println("orbiter thing2"+randR.getStair());
            // while (outerRoom) {
            // outerRoom = true;
            // if (!randR.getStair()) {
            // outerRoom = false;
            // }
            // randR = this.Temple.get(randRoomIndex+1);
            // }
            Orbiter o = new Orbiter("O", randR.getRoomID());
            // this.Creatures.add(o);
            randR.addCreatureToRoom(o);
            this.Creatures.add(o);
            // update room in temple
            // this.Temple.set(randRoomIndex, randR);
        }
        // spawn Seekers
        for (int i = 0; i < 4; i++) {
            int rand = r.nextInt(this.Temple.size());
            Room randR = this.Temple.get(rand);
            if (randR == startRoom) {
                rand++;
                randR = this.Temple.get(rand);
            }
            Seeker s = new Seeker("S", randR.getRoomID());
            // this.Creatures.add(s);
            randR.addCreatureToRoom(s);
            // System.out.print("Seekers"+ Arrays.toString(randR.getRoomID()));
            this.Creatures.add(s);
            // update temple
            // this.Temple.set(rand, randR);
        }
        // spawn blinkers
        for (int i = 0; i < 4; i++) {
            int[] fourthFloorRoom = { 4, r.nextInt(3), r.nextInt(3) };
            // System.out.println(Arrays.toString(fourthFloorRoom));
            Room blinkerRoom = this.getRoomFromTemple(fourthFloorRoom);
            Blinker b = new Blinker("B", fourthFloorRoom);
            blinkerRoom.addCreatureToRoom(b);
            // System.out.println(blinkerRoom.getCreaturesNames());
            this.Creatures.add(b);
            // int roomIndex = this.Temple.indexOf(blinkerRoom);
            // this.Temple.set(roomIndex, r);
        }
        // for(int i = 0; i < this.getTempleSize(); i++){
        // Room printRoom = this.Temple.get(i);
        // System.out.println(Arrays.toString(printRoom.getRoomID())+printRoom.getCreaturesNames());
        // }

    }

    // sum the total of all the adventures treasure
    public int getTotalTreasure() {
        int sum = 0;
        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            sum += a.getTreasure();
        }
        return sum;
    }

    // displays the board after a round
    public void displayBoard() {
        // for(int i = 0; i < this.getTempleSize(); i++){
        // Room printRoom = this.Temple.get(i);
        // System.out.println(Arrays.toString(printRoom.getRoomID())+printRoom.getAdventuresNames()+":"+printRoom.getCreaturesNames());

        // }
        // int templeSize =this.getTempleSize();
        int[] startRoomID = { 0, 1, 1 };
        Room startRoom = this.getRoomFromTemple(startRoomID);
        System.out.println(Arrays.toString(startRoom.getRoomID()) + startRoom.getAdventuresNames() + ":"
                + startRoom.getCreaturesNames() + " ");

        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int[] id = { i, j, k };
                    Room printRoom = this.getRoomFromTemple(id);
                    System.out.print(Arrays.toString(printRoom.getRoomID()) + printRoom.getAdventuresNames() + ":"
                            + printRoom.getCreaturesNames() + " ");
                    // System.out.println("qkjhergege");
                }
                System.out.println("");
            }
            System.out.println("");
        }

        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            System.out.println(a.getType() + ":Treasure(s) " + a.getTreasure() + ":Damage " + a.getDamage());
        }

        int[] creatureCounts = this.getCreatureCount();
        System.out.println("Obiter remaining: " + creatureCounts[0]);
        System.out.println("Seekers remaining: " + creatureCounts[1]);
        System.out.println("Blinkers remaining: " + creatureCounts[2]);

    }

    public ArrayList<String> getCreaturesNames() {
        ArrayList<String> aNames = new ArrayList<>();
        if (this.Creatures.size() == 0) {
            aNames.add("");
            return aNames;
        } else {
            for (int i = 0; i < this.Creatures.size(); i++) {
                Creature tempA = this.Creatures.get(i);

                aNames.add(tempA.getCreatureName());
            }
            return aNames;
        }
    }

    public int[] getCreatureCount() {
        int[] totals = { 0, 0, 0 };
        ArrayList<String> creaturesInTotal = this.getCreaturesNames();
        totals[0] = Collections.frequency(creaturesInTotal, "O");
        totals[1] = Collections.frequency(creaturesInTotal, "S");
        totals[2] = Collections.frequency(creaturesInTotal, "B");
        return totals;

    }

    // returns true is end conditions are met and prints the result
    // returns false if end conditions not
    public Boolean checkEndConditions() {
        if (this.Adventurers.size() == 0) {
            System.out.println("All the Adventurers are dead, Lose!");
            return true;
        } else if (this.Creatures.size() == 0) {
            System.out.println("All the Creatures are dead, Win!");
            return true;
        } else if (this.getTotalTreasure() >= 10) {
            System.out.println("Adventurers found enough treasure, Win!");
            return true;
        }
        return false;
    }

    public int[] addIds(int[] a, int[] b) {
        int[] retID = { 0, 0, 0 };
        for (int i = 0; i < 3; i++) {
            retID[i] = a[i] + b[i];
        }
        return retID;
    }

    public Boolean isValidMove(int[] currentPosition, int[] offset) {
        int[] potentialMove = this.addIds(currentPosition, offset);

        if (potentialMove[2] < 0 || potentialMove[2] > 4) {
            return false;
        }
        if (potentialMove[1] < 0 || potentialMove[1] > 3) {
            return false;

        }
        return true;
    }

    public int getTempleSize() {
        return this.Temple.size();
    }

    public Room getRoomFromTemple(int index) {
        return this.Temple.get(index);
    }

    public Room findRoom(Creature c) {
        for (int i = 0; i < this.getTempleSize(); i++) {
            Room tempR = this.Temple.get(i);
            ArrayList<Creature> creaturesInTempR = tempR.getCreatures();
            for (int j = 0; j < creaturesInTempR.size(); j++) {
                if (creaturesInTempR.get(i) == c) {
                    return tempR;
                }
            }
        }
        return null;
    }

    public void moveCreatures() {
        for (int i = 0; i < this.Creatures.size(); i++) {
            Creature c = this.Creatures.get(i);
            switch (c.getCreatureName()) {
                case "O":// orbiter hopefully
                    System.out.println("OClass");
                    System.out.println("orbiter");
                    
                    
                    System.out.println(Arrays.toString(c.getCurrentPosition()));
                    // Room currentRoom = t.getRoomFromTemple(this.getCurrentPosition());
                    Room currentRoom = this.findRoom(c);
                    System.out.println(Arrays.toString(currentRoom.getRoomID()));
                    int indexForMove = Object.getOuterRooms().indexOf(currentRoom);
                    if(c.getDirection()){
                        //adding
                        int newIndex = indexForMove +1;
                        if(newIndex < 0){
                            newIndex = c.getOuterRooms().size();
                        }
                        if(newIndex > c.getOuterRooms().size()){
                            newIndex = 0;
                        }
                        currentRoom.deleteCreatureFromRoom(c);
                        Room nextRoom = c.getOuterRooms().get(newIndex);
                        nextRoom.addCreatureToRoom(c);
                        c.setCurrentPosition(nextRoom.getRoomID());
                    }else{
                        //subtracting
                        int newIndex = indexForMove -1;
                        if(newIndex < 0){
                            newIndex = c.getOuterRooms().size();
                        }
                        if(newIndex > c.getOuterRooms().size()){
                            newIndex = 0;
                        }
                        currentRoom.deleteCreatureFromRoom(c);
                        Room nextRoom = c.getOuterRooms().get(newIndex);
                        nextRoom.addCreatureToRoom(c);
                        c.setCurrentPosition(nextRoom.getRoomID());
                    }
                    break;
                case "S":// seeker
                    // System.out.println("SClass");
                    // goes if adventurer is near
                    // check if in adjacent positions
                    // System.out.println("Seeker");

                    int[] offsetNorth = { 0, 1, 0 };
                    int[] offsetSouth = { 0, -1, 0 };
                    int[] offsetEast = { 0, 0, 1 };
                    int[] offsetWest = { 0, 0, -1 };
                    // calculate moves
                    // check if valid move
                    int[] currentPosition = c.getCurrentPosition();
                    boolean n = this.isValidMove(currentPosition, offsetNorth);
                    boolean s = this.isValidMove(currentPosition, offsetSouth);
                    boolean e = this.isValidMove(currentPosition, offsetEast);
                    boolean w = this.isValidMove(currentPosition, offsetWest);
                    System.out.print(n);
                    System.out.print(s);
                    System.out.print(e);
                    System.out.print(w);
                    ArrayList<Integer> possibles = new ArrayList<>();
                    if (n) {
                        possibles.add(1);
                    }
                    if (s) {
                        possibles.add(2);
                    }
                    if (e) {
                        possibles.add(3);
                    }
                    if (w) {
                        possibles.add(4);
                    }
                    int way = possibles.get(r.nextInt(possibles.size()));
                    Room currRoom = this.getRoomFromTemple(currentPosition);
                    switch (way) {
                        case 1:// north
                            int[] nextRoomId = this.addIds(currentPosition, offsetNorth);
                            Room nextRoom = this.getRoomFromTemple(nextRoomId);
                            if (nextRoom.getAdventurers().size() > 0) {
                                //
                                // if an adventurer is there move
                                c.setCurrentPosition(nextRoomId);
                                // leave old room list
                                currRoom.deleteCreatureFromRoom(c);
                                // move to new room list
                                nextRoom.addCreatureToRoom(c);
                            }
                            break;
                        case 2:// south
                            int[] nextRoomIdS = this.addIds(currentPosition, offsetSouth);
                            Room nextRoomS = this.getRoomFromTemple(nextRoomIdS);
                            if (nextRoomS.getAdventurers().size() > 0) {
                                //
                                // if an adventurer is there move
                                c.setCurrentPosition(nextRoomIdS);
                                // leave old room list
                                currRoom.deleteCreatureFromRoom(c);
                                // move to new room list
                                nextRoomS.addCreatureToRoom(c);
                            }
                            break;
                        case 3:// east
                            int[] nextRoomIdE = this.addIds(currentPosition, offsetEast);
                            Room nextRoomE = this.getRoomFromTemple(nextRoomIdE);
                            if (nextRoomE.getAdventurers().size() > 0) {
                                //
                                // if an adventurer is there move
                                c.setCurrentPosition(nextRoomIdE);
                                // leave old room list
                                currRoom.deleteCreatureFromRoom(c);
                                // move to new room list
                                nextRoomE.addCreatureToRoom(c);
                            }
                            break;
                        case 4:// west
                            int[] nextRoomIdW = this.addIds(currentPosition, offsetWest);
                            Room nextRoomW = this.getRoomFromTemple(nextRoomIdW);
                            if (nextRoomW.getAdventurers().size() > 0) {
                                //
                                // if an adventurer is there move
                                c.setCurrentPosition(nextRoomIdW);
                                // leave old room list
                                currRoom.deleteCreatureFromRoom(c);
                                // move to new room list
                                nextRoomW.addCreatureToRoom(c);
                            }
                            break;
                    }
                    // now will check if it is a possible room for all
                    // if it is then we will check if there is an adventurer
                    // if there is update currposition and lists
                    // initate a fight?
                    // will move to the first room with an adventurer
                    // otherwise doesn't do anything
                    break;
                case "B": // blinker
                    // System.out.println("blinkerClass");
                    // System.out.println(Arrays.toString(c.getCurrentPosition()));
                    // Room currentRoom = t.findRoom(this);
                    Room currentRoom = this.getRoomFromTemple(c.getCurrentPosition());
                    // System.out.println(Arrays.toString(currentRoom.getRoomID()));
                    // randomly pick a index from temple
                    int newRoomIndex = r.nextInt(this.getTempleSize());
                    // find that room
                    Room nextRoom = this.getRoomFromTemple(newRoomIndex);
                    // move to room
                    currentRoom.deleteCreatureFromRoom(c);
                    nextRoom.addCreatureToRoom(c);
                    c.setCurrentPosition(nextRoom.getRoomID());

                    break;
            }
        }

    }

    public void oneTurn() {
        // Adventurers move
        // then fight
        // if the room is empty then search
        // then creatures turn
        // move
        this.moveCreatures();
        // for(int i = 0; i < this.Creatures.size(); i++){
        // Creature c = Creatures.get(i);
        // c.move();

        // }
        // possibly fight
    }
}
