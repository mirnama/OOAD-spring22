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




    public int getTotal() {
//        System.out.println("public void getTotal "+total);
        return total;
    }

    public void setTotal(int total) {
        this.total = total;

    }
    public void playGame(){
        Brawler b = new Brawler();
        Thief thief = new Thief();
        Orbiter creature = new Orbiter();

//        System.out.printf("Adventure Name is %s Adventure Dice total is: %d\n", b.getAdventurerName(),  b.getTotal());
//
//        System.out.printf("Adventure name is %s Dice  total is: %d\n", thief.getAdventurerName(),  thief.getTotal());
//
//        System.out.printf("Creature name is %s Dice  total is: %d\n", creature.getCreatureName(),  creature.getTotal());

        if(b.getTotal()< creature.getTotal()){

            b.points-=1;
            b.damage+=1;

        }else if (b.getTotal()>creature.getTotal()){

            b.treasure+=1;
        }
        System.out.printf("%s - %d Treasure - (%d) Damage\n",b.getAdventurerName(),b.damage, b.treasure);
    }
    public void printReport() {
        System.out.println("Game Report");
        playGame();


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
