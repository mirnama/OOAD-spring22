import java.util.Arrays;
import java.util.Random;

public class Blinker extends Creature {

    public Blinker(String type, int[] newPos) {
        super(type, newPos);
        //TODO Auto-generated constructor stub
    }
    // public void move(){
    //     Turn t = new Turn();
    //     Random r = new Random();
    //     //current room
    //     System.out.println("blinkerClass");
    //     System.out.println(Arrays.toString(this.getCurrentPosition()));
    //     Room currentRoom = t.findRoom(this);
    //     // Room currentRoom = t.getRoomFromTemple(this.getCurrentPosition());
    //     System.out.println(Arrays.toString(currentRoom.getRoomID()));
    //     //randomly pick a index from temple
    //     int newRoomIndex = r.nextInt(t.getTempleSize());
    //     //find that room
    //     Room nextRoom = t.getRoomFromTemple(newRoomIndex);
    //     //move to room
    //     currentRoom.deleteCreatureFromRoom(this);
    //     nextRoom.addCreatureToRoom(this);
    //     this.setCurrentPosition(nextRoom.getRoomID());
    // }
    
}
