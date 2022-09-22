import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Room> Temple= new ArrayList<Room>();
    ArrayList<Creature> Creatures= new ArrayList<Creature>();
    ArrayList<Adventurer> Adventurers= new ArrayList<Adventurer>();
//    private String creatureName;
    private int dis1;
    private int dis2;



    private int total;
    Random r = new Random();
    public class Turn{}
    public class Room{

        public ArrayList<Integer> getRoomID() {
            return null;
        }

		public void deleteAdventurerFromRoom(Game.Adventurer tempA) {
		}

        public void addAdventurerToRoom(Game.Adventurer tempA) {
        }}
    public class Creature{
        private String creatureName;

        public String getCreatureName() {
            return creatureName;
        }
        public void setCreatureName(String name){
            this.creatureName = name;

        }

    }




    public void setDis1(int dis1) {
        dis1 = r.nextInt(6)+1;

        this.dis1 = dis1;
        System.out.println("dice 1 from rollTheDice1: "+dis1);
    }

    public int getDis2() {
        return dis2;
    }

    public void setDis2(int dis2) {
        dis2 = r.nextInt(6)+1;

        this.dis2 = dis2;
        System.out.println("dice 2 from rollTheDice2: "+dis1);
    }
    public int getTotal() {
//        System.out.println("public void getTotal "+total);
        return total;
    }

    public void setTotal(int total) {
        this.total = dis1+dis2;
//        System.out.println("public void setTotal "+total);
    }



    public int rollTheDice(){
        dis1 = r.nextInt(6)+1;
        dis2 = r.nextInt(6)+1;
//        System.out.println("dice 1 from rollTheDice: "+dis1);
//        System.out.println("dice 2 from rollTheDice: "+dis2);
        return dis1+dis2;
    }
    public Room getRoom(ArrayList<Integer> id){
        for(int i = 0; i < this.Temple.size(); i++){
            Room tempR= this.Temple.get(i);
            if(tempR.getRoomID() == id){
                return tempR;
            }
        }
    }


    public class Adventurer{

		public ArrayList<Integer> getCurrentPosition() {
			return null;
		}}
}
