import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class Orbiter extends Creature{
    //true for ClockWise
    //False for AnticlockWise
    private boolean direction; 
    ArrayList<Room> outerRoomsOnFloor = new ArrayList<>();
    public Orbiter(String type, int[] newPos) {
        super(type, newPos);
        //TODO Auto-generated constructor stub
        //also picks a boolean for direction
        Random r = new Random();
        this.direction= r.nextBoolean();
        //populates the prvate list of outerrooms
        Turn t = new Turn();
        int[] currentPosition = this.getCurrentPosition();
        this.outerRoomsOnFloor.add(t.getRoomFromTemple(currentPosition));
        for(int i = 0; i < 3;i++){
            for(int j = 0; j< 3;j++){
                if(i != 1 & j != 1){
    
                    int[] tempID ={currentPosition[0], i, j};
                    this.outerRoomsOnFloor.add(t.getRoomFromTemple(tempID));
                }
            }
        }

    }
    public Boolean getDirection(){
        return this.direction;
    }

    public ArrayList<Room> getOuterRooms(){
        return this.outerRoomsOnFloor;
    }



    public void move(){
        System.out.println("orbiter");
        Turn t = new Turn();
        System.out.println(Arrays.toString(this.getCurrentPosition()));
        // Room currentRoom = t.getRoomFromTemple(this.getCurrentPosition());
        Room currentRoom = t.findRoom(this);
        System.out.println(Arrays.toString(currentRoom.getRoomID()));
        int indexForMove = this.outerRoomsOnFloor.indexOf(currentRoom);
        if(this.direction){
            //adding
            int newIndex = indexForMove +1;
            if(newIndex < 0){
                newIndex = this.outerRoomsOnFloor.size();
            }
            if(newIndex > this.outerRoomsOnFloor.size()){
                newIndex = 0;
            }
            currentRoom.deleteCreatureFromRoom(this);
            Room nextRoom = this.outerRoomsOnFloor.get(newIndex);
            nextRoom.addCreatureToRoom(this);
            this.setCurrentPosition(nextRoom.getRoomID());
        }else{
            //subtracting
            int newIndex = indexForMove -1;
            if(newIndex < 0){
                newIndex = this.outerRoomsOnFloor.size();
            }
            if(newIndex > this.outerRoomsOnFloor.size()){
                newIndex = 0;
            }
            currentRoom.deleteCreatureFromRoom(this);
            Room nextRoom = this.outerRoomsOnFloor.get(newIndex);
            nextRoom.addCreatureToRoom(this);
            this.setCurrentPosition(nextRoom.getRoomID());
        }
    }
    
}
