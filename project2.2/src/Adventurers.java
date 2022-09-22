import java.util.ArrayList;
import java.util.Random;

public class Adventurers extends Game {
    private String adventurerName;
    int points;

    ArrayList<Integer> currPosition;
    private ArrayList<String> adventurerObjec = new ArrayList<>();
  

    int treasure;
    int damage;


    // public int getDis2() {
    // return dis2;
    // }

    public String getAdventurerName() {
        return adventurerName;
    }

    public ArrayList<Integer> getCurrentPosition() {
        return currPosition;
    }

    public void setCurrPosition(ArrayList<Integer> newCurr) {
        currPosition = newCurr;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }

    public void move() {
        for (int i = 0; i < this.Adventurers.size(); i++) {
            Adventurer tempA = this.Adventurers.get(i);
            Room currRoom = this.getRoom(tempA.getCurrentPosition());
            ArrayList<String> possibleMoves = new ArrayList<>();
            ArrayList<Integer> currXYZ = currRoom.getRoomID();
            // number refers to the directrion one moves
            // 1= Up 2=Down 3=North 4= south 5= east 6=west
            if (currXYZ.get(0) > 0 & currXYZ.get(0) < 4) {
                // free riegn up and down
                possibleMoves.add("Up");
                possibleMoves.add("Down");

            } else if (currXYZ.get(0) == 1) {
                possibleMoves.add("Up");
            } else if (currXYZ.get(0) == 4) {
                possibleMoves.add("Down");
            }

            if (currXYZ.get(1) > 0 & currXYZ.get(1) < 3) {
                possibleMoves.add("North");
                possibleMoves.add("South");
            } else if (currXYZ.get(1) == 0) {
                possibleMoves.add("South");
            } else if (currXYZ.get(1) == 3) {
                possibleMoves.add("North");
            }

            if (currXYZ.get(2) > 0 & currXYZ.get(2) < 4) {
                possibleMoves.add("East");
                possibleMoves.add("West");
            } else if (currXYZ.get(1) == 0) {
                possibleMoves.add("East");
            } else if (currXYZ.get(1) == 4) {
                possibleMoves.add("West");
            }
            int choice = r.nextInt(possibleMoves.size()) + 1;
            String move = possibleMoves.get(choice);
            ArrayList<Integer> newPos = new ArrayList<>();
            int x = currXYZ.get(0);
            int y = currXYZ.get(1);
            int z = currXYZ.get(2);
            if (move == "Up") {
                x++;
            } else if (move == "Down") {
                x--;
            } else if (move == "North") {
                y++;
            } else if (move == "South") {
                y--;
            } else if (move == "East") {
                z++;
            } else if (move == "West") {
                z--;
            }
            newPos.add(0,x);
            newPos.add(1,y);
            newPos.add(2, z);
            this.setCurrPosition(newPos);
            currRoom.deleteAdventurerFromRoom(tempA);
            Room newRoom = this.getRoom(newPos);
            newRoom.addAdventurerToRoom(tempA);
            

        }
    }

}
