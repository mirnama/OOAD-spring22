import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Room> Temple= new ArrayList<Room>();
    ArrayList<Creature> Creatures= new ArrayList<>();
    ArrayList<Adventurers> Adventurers= new ArrayList<>();
//    private String creatureName;
    private int dis1;
    private int dis2;



    private int total;
    Random r = new Random();

//    protected Room getRoom(ArrayList<Integer> currentPosition) {
//        return null;
//    }




        public ArrayList<Integer> getRoomID() {
            return null;
        }

		public void deleteAdventurerFromRoom(Adventurers tempA) {
		}

        public void addAdventurerToRoom(Adventurers tempA) {
        }

        private String creatureName;



        public int getTotal() {
//        System.out.println("public void getTotal "+total);
        return total;
    }

    public void setTotal(int total) {
        this.total = rollTheDice();

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
        for (int i = 0; i< b.getPoints(); i++){
            int point = b.getPoints();
            if(b.getTotal()< creature.getTotal()){

                point-=1;
                b.setPoints(point);
                b.damage+=1;

            }else if (b.getTotal()>creature.getTotal()){

                b.treasure+=1;
            }
            System.out.printf("%s - %d Treasure - (%d) Damage\n",b.getAdventurerName(),b.treasure, b.damage);
        }



        if(thief.getTotal()< creature.getTotal()){
            int point = thief.getPoints();
            point-=1;
            thief.setPoints(point);
            thief.damage+=1;

        }else if (thief.getTotal()>creature.getTotal()){

            thief.treasure+=1;
        }
        System.out.printf("%s - %d Treasure - (%d) Damage\n",thief.getAdventurerName(),thief.treasure, thief.damage);
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
        return null;
    }




		public ArrayList<Integer> getCurrentPosition() {
			return null;
		}
}
