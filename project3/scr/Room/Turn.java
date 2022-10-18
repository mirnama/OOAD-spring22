package Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Random;
import Creature.*;
import Adventurer.*;
import Logger.Logger;
import  Search.*;
import Room.*;
import combat.*;
import Celebration.*;
import Search.*;
import com.sun.tools.javac.Main;


public class Turn  implements Logger{
    ArrayList<Room> Temple = new ArrayList<Room>();
    ArrayList<Creature> Creatures = new ArrayList<Creature>();
    ArrayList<Adventurer> Adventurers = new ArrayList<Adventurer>();

    Random r = new Random();

    // Takes in a room Id and finds it in the temple
    // returns a room object or null
    public Room getRoomFromTemple(int[] id) {
        for (int i = 0; i < this.Temple.size(); i++) {
            Room r = this.Temple.get(i);
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
        return dis1 + dis2;
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
        out(Arrays.toString(startRoom.getRoomID()) + startRoom.getAdventuresNames() + ":"
                + startRoom.getCreaturesNames() + " ");
//        System.out.println(Arrays.toString(startRoom.getRoomID()) + startRoom.getAdventuresNames() + ":"
//                + startRoom.getCreaturesNames() + " ");

        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int[] id = { i, j, k };
                    Room printRoom = this.getRoomFromTemple(id);
                    System.out.print(Arrays.toString(printRoom.getRoomID()) + printRoom.getAdventuresNames() + ":"
                            + printRoom.getCreaturesNames() + " ");
                    // System.out.println("qkjhergege");
                }
                out("");
            }
            out("");
        }

        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            out(a.getType() + ":Treasure(s) " + a.getTreasure() + ":Damage " + a.getDamage());
        }

        int[] creatureCounts = this.getCreatureCount();
        out("Obiter remaining: " + creatureCounts[0]);
        out("Seekers remaining: " + creatureCounts[1]);
        out("Blinkers remaining: " + creatureCounts[2]);

    }
    public void printReport(){
        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            out(a.getType() + ":Treasure(s) " + a.getTreasure() + ":Damage " + a.getDamage());
        }

        int[] creatureCounts = this.getCreatureCount();
        out("Obiter remaining: " + creatureCounts[0]);
        out("Seekers remaining: " + creatureCounts[1]);
        out("Blinkers remaining: " + creatureCounts[2]);
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

    public int getTotalDamage() {
        int sum = 0;
        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            sum += a.getDamage();
        }
        return sum;
    }

    // returns true is end conditions are met and prints the result
    // returns false if end conditions not
    public Boolean checkEndConditions() {
        if (this.Adventurers.size() == 0) {
            out("All the Adventurers are dead, Lose!");
            return true;
        } else if (this.Creatures.size() == 0) {
            out("All the Creatures are dead, Win!");
            return true;
        } else if (this.getTotalTreasure() >= 10) {
            out("Adventurers found enough treasure, Win!");
            return true;
        }
        return false;
    }

    public int[] addIds(int[] a, int[] b) {
        int[] retID = { 0, 0, 0 };
        for (int i = 0; i < 3; i++) {
            retID[i] = a[i] + b[i];
        }

        if (retID[0] < 0) {
            retID[0] = 0;
        }
        if(retID[1]<0){
            retID[1]=0;
        }
        if(retID[2]<0){
            retID[2]=0;
        }
        if(retID[0]>2){
            retID[0]=2;
        }
        if(retID[1]>2){
            retID[1]=2;
        }
        if(retID[2]>2){
            retID[2]=2;
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

    public ArrayList<Integer> getPossibleMovesAdventurers(int[] currentPosition) {
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        Room currentRoom = this.getRoomFromTemple(currentPosition);
        if (currentRoom.getStair()) {
            // all moves possibles
            possibleMoves.add(1);
            possibleMoves.add(2);
            possibleMoves.add(3);
            possibleMoves.add(4);
            if (currentPosition[0] > 0 & currentPosition[0] < 4) {
                possibleMoves.add(5);
                possibleMoves.add(6);
            } else if (currentPosition[0] == 0) {
                possibleMoves.add(5);
            } else if (currentPosition[0] == 4) {
                possibleMoves.add(6);
            }

        } else {
            if (currentPosition[1] == 0) {
                possibleMoves.add(2);
            }
            if (currentPosition[1] == 2) {
                possibleMoves.add(1);
            }
            if (currentPosition[2] == 0) {
                possibleMoves.add(3);
            }
            if (currentPosition[2] == 2) {
                possibleMoves.add(4);
            }

        }

        return possibleMoves;
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

    public ArrayList<Integer> getPossibleMovesOrbiter(int[] currentPosition) {
        boolean easySquare = false;
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        // int[] startP = { 0, 1, 1 };
        // Room currentRoom = this.getRoomFromTemple(currentPosition);
        if (currentPosition[2] == 1) {
            // valid options are w e
            possibleMoves.add(3);
            possibleMoves.add(4);
            easySquare = true;
        } else if (currentPosition[1] == 1) {
            // ns
            possibleMoves.add(1);
            possibleMoves.add(2);

            easySquare = true;
        }
        if (!easySquare) {
            if (currentPosition[1] == 0) {
                possibleMoves.add(2);

            }
            if (currentPosition[1] == 2) {
                possibleMoves.add(1);

            }
            if (currentPosition[2] == 0) {
                possibleMoves.add(3);

            }
            if (currentPosition[2] == 2) {
                possibleMoves.add(4);

            }
        }
        return possibleMoves;
    }

    public void moveCreatures() {
        for (int i = 0; i < this.Creatures.size(); i++) {
            Creature c = this.Creatures.get(i);
            int[] offsetNorth = { 0, -1, 0 };// 1
            int[] offsetSouth = { 0, 1, 0 };// 2
            int[] offsetEast = { 0, 0, 1 };// 3
            int[] offsetWest = { 0, 0, -1 };// 4

            switch (c.getCreatureName()) {
                case "O":// orbiter hopefully
                    // System.out.println("OClass");
                    // System.out.println("orbiter");
                    int[] orbPosition = c.getCurrentPosition();
                    Room orbCurrentRoom = this.getRoomFromTemple(orbPosition);

                    ArrayList<Integer> possibleValidMoves = this.getPossibleMovesOrbiter(orbPosition);
                    int randNextC = r.nextInt(possibleValidMoves.size());
                    int randChoice = possibleValidMoves.get(randNextC);
                    // System.out.println(Arrays.toString(orbPosition));
                    // System.out.println(possibleValidMoves);
                    // System.out.println(randChoice);
                    switch (randChoice) {
                        case 1:
                            // north
                            int[] nextRoomId = this.addIds(orbPosition, offsetNorth);
                            // System.out.println(Arrays.toString(nextRoomId));
                            Room nextRoom = this.getRoomFromTemple(nextRoomId);
                            // if (nextRoom.getAdventurers().size() > 0) {
                            // //
                            // // if an adventurer is there move
                            c.setCurrentPosition(nextRoomId);
                            // // leave old room list
                            orbCurrentRoom.deleteCreatureFromRoom(c);
                            // // move to new room list
                            nextRoom.addCreatureToRoom(c);
                            // }
                            break;
                        case 2:
                            // south
                            int[] nextRoomIdOS = this.addIds(orbPosition, offsetSouth);
                            // System.out.println(Arrays.toString(nextRoomIdOS));
                            Room nextRoomOS = this.getRoomFromTemple(nextRoomIdOS);
                            // if (nextRoom.getAdventurers().size() > 0) {
                            // //
                            // // if an adventurer is there move
                            c.setCurrentPosition(nextRoomIdOS);
                            // // leave old room list
                            orbCurrentRoom.deleteCreatureFromRoom(c);
                            // // move to new room list
                            nextRoomOS.addCreatureToRoom(c);
                            break;
                        case 3:
                            // east
                            int[] nextRoomIdOE = this.addIds(orbPosition, offsetEast);
                            // System.out.println(Arrays.toString(nextRoomIdOE));
                            Room nextRoomOE = this.getRoomFromTemple(nextRoomIdOE);
                            // if (nextRoom.getAdventurers().size() > 0) {
                            // //
                            // // if an adventurer is there move
                            c.setCurrentPosition(nextRoomIdOE);
                            // // leave old room list
                            orbCurrentRoom.deleteCreatureFromRoom(c);
                            // // move to new room list
                            nextRoomOE.addCreatureToRoom(c);
                            break;
                        case 4:
                            // west
                            int[] nextRoomIdOW = this.addIds(orbPosition, offsetWest);
                            // System.out.println(Arrays.toString(nextRoomIdOW));
                            Room nextRoomOW = this.getRoomFromTemple(nextRoomIdOW);
                            // if (nextRoom.getAdventurers().size() > 0) {
                            // //
                            // // if an adventurer is there move
                            c.setCurrentPosition(nextRoomIdOW);
                            // // leave old room list
                            orbCurrentRoom.deleteCreatureFromRoom(c);
                            // // move to new room list
                            nextRoomOW.addCreatureToRoom(c);
                            break;

                    }

                    break;
                case "S":// seeker
                    // System.out.println("SClass");
                    // goes if adventurer is near
                    // check if in adjacent positions
                    // System.out.println("Seeker");

                    int[] currentPosition = c.getCurrentPosition();

                    ArrayList<Integer> possibles = this.getPossibleMovesAdventurers(currentPosition);

                    int randomIndex = r.nextInt(possibles.size());
                    int way = possibles.get(randomIndex);
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
                    // System.out.println("blinker");
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

    public void moveAdventurers() {
        int[] offsetNorth = { 0, 1, 0 };// 1
        int[] offsetSouth = { 0, -1, 0 };// 2
        int[] offsetEast = { 0, 0, 1 };// 3
        int[] offsetWest = { 0, 0, -1 };// 4
        int[] offsetUp = { 1, 0, 0 };// 5
        int[] offsetDown = { -1, 0, 0 };// 6
        // System.out.println("here");
        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer a = this.Adventurers.get(i);
            // System.out.println(a.getAdventurerName());
            ArrayList<Integer> possibleMoves = new ArrayList<>();

            int[] currentPosition = a.getCurrentPosition();
            Room currentRoom = this.getRoomFromTemple(currentPosition);
            possibleMoves = this.getPossibleMovesAdventurers(currentPosition);

            // System.out.println(possibleMoves.size());
            int pMSize = possibleMoves.size();
            int rNum = r.nextInt(pMSize);
            int randNextMoveChoice = possibleMoves.get(rNum);
            int[] startP = { 0, 1, 1 };
            if (Arrays.equals(currentPosition, startP)) {
                // must go up on first move
                randNextMoveChoice = 5;
            }
            // System.out.println(randNextMoveChoice);
            switch (randNextMoveChoice) {
                case 1:
                    // north
                    // System.out.println(Arrays.toString(currentPosition));
                    int[] nextRoomId = this.addIds(currentPosition, offsetNorth);
                    // System.out.println("North" + Arrays.toString(nextRoomId));
                    Room nextRoom = this.getRoomFromTemple(nextRoomId);
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomId);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoom.addAdventurerToRoom(a);
                    // }
                    break;
                case 2:
                    // south
                    int[] nextRoomIdS = this.addIds(currentPosition, offsetSouth);
                    Room nextRoomS = this.getRoomFromTemple(nextRoomIdS);
                    // System.out.println(Arrays.toString(currentPosition));
                    // System.out.println("south" + Arrays.toString(nextRoomIdS));
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomIdS);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoomS.addAdventurerToRoom(a);
                    break;
                case 3:
                    // EAST
                    int[] nextRoomIdE = this.addIds(currentPosition, offsetEast);
                    Room nextRoomE = this.getRoomFromTemple(nextRoomIdE);
                    // System.out.println("east" + Arrays.toString(nextRoomIdE));
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomIdE);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoomE.addAdventurerToRoom(a);
                    break;
                case 4:
                    // WEST
                    int[] nextRoomIdW = this.addIds(currentPosition, offsetWest);
                    Room nextRoomW = this.getRoomFromTemple(nextRoomIdW);
                    // System.out.println("west" + Arrays.toString(nextRoomIdW));
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomIdW);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoomW.addAdventurerToRoom(a);
                    break;
                case 5:
                    // UP
                    int[] nextRoomIdU = this.addIds(currentPosition, offsetUp);
                    Room nextRoomU = this.getRoomFromTemple(nextRoomIdU);
                    // System.out.println("up" + Arrays.toString(nextRoomIdU));
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomIdU);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoomU.addAdventurerToRoom(a);
                    break;
                case 6:
                    // DOWN
                    int[] nextRoomIdD = this.addIds(currentPosition, offsetDown);
                    Room nextRoomD = this.getRoomFromTemple(nextRoomIdD);
                    // System.out.println("Down" + Arrays.toString(nextRoomIdD));
                    // if (nextRoom.getAdventurers().size() > 0) {
                    // //
                    // // if an adventurer is there move
                    a.setCurrentPosition(nextRoomIdD);
                    // // leave old room list
                    currentRoom.deleteAdventurerFromRoom(a);
                    // // move to new room list
                    nextRoomD.addAdventurerToRoom(a);
                    break;

            }

        }

    }

    public ArrayList<Room> checkFights() {
        ArrayList<Room> roomsWFights = new ArrayList<>();
        for (int i = 0; i < this.getTempleSize(); i++) {
            Room tRoom = this.Temple.get(i);
            if (tRoom.isFight()) {
                roomsWFights.add(tRoom);
            }
        }
        return roomsWFights;
    }

    // public void fight(ArrayList<Room> fightingRooms) {
    //     for (int i = 0; i < fightingRooms.size(); i++) {
    //         Room tempRoom = fightingRooms.get(i);
    //         String loser = tempRoom.fight();
    //         switch (loser) {
    //             case "c":
    //                 Creature c = tempRoom.killCreature();
    //                 this.Creatures.remove(c);

    //                 break;
    //             case "a":
    //                 Adventurer a = tempRoom.getFirstAdventurer();
    //                 a.takeDamage();
    //                 if(a.getDamage() >3){
    //                     System.out.println(a.getType()+ " has died!");
    //                     this.Adventurers.remove(a);
    //                 }
    //                 break;
    //             case "t":
    //                 break;
    //         }
    //     }
    // }

    // public void search() {
    //     for (int i = 0; i < this.Adventurers.size(); i++) {
    //         Adventurer a = this.Adventurers.get(i);
    //         Room currentRoom = this.getRoomFromTemple(a.getCurrentPosition());
    //         if (!currentRoom.isFight()) {
    //             if (a.search()) {
    //                 a.addTreasure();
    //             }
    //         }
    //     }
    // }

    public void oneTurn() {
        // Adventurers move
        // then fight
        // if the room is empty then search
        // then creatures turn
        // move
        this.moveAdventurers();
        ArrayList<Room> fightingRooms = this.checkFights();
        if (fightingRooms.size() > 0) {
            // fight
            // this.fight(fightingRooms);
            for(int i = 0; i < fightingRooms.size(); i++){
                ArrayList<Adventurer> as = (fightingRooms.get(i)).getAdventurers();
                for( int j = 0; j < as.size(); j++){
                    (as.get(j)).fight();
                }
            }
            // String winner =
        } else {
            // search
            for(int i = 0; i < Adventurers.size(); i++){
                Adventurers.get(i).search();
            }
        }
        this.moveCreatures();
        ArrayList<Room> fightingRoomsC = this.checkFights();
        for(int i = 0; i < fightingRoomsC.size(); i++){
            ArrayList<Adventurer> as = (fightingRoomsC.get(i)).getAdventurers();
            for( int j = 0; j < as.size(); j++){
                (as.get(j)).fight();
            }
        }
        // for(int i = 0; i < this.Creatures.size(); i++){
        // Creature c = Creatures.get(i);
        // c.move();

        // }
        // possibly fight
    }
}
