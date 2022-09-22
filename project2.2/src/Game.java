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
    public class Room{}
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
        this.total = total;
//        System.out.println("public void setTotal "+total);
    }
    public void playGame(){
        Brawler b = new Brawler();
        Thief thief = new Thief();
        Orbiter creature = new Orbiter();
        System.out.println("Adventure Name "+b.getAdventurerName());
        System.out.printf("Adventure total is: %d\n",  b.getTotal());
        System.out.println("Adventure Name "+thief.getAdventurerName());
        System.out.printf("Adventure total is: %d\n",  thief.getTotal());
        System.out.println("Creature  Name "+creature.getCreatureName());
        System.out.printf("Creature total is: %d\n",  creature.getTotal());
        if(b.getTotal()< thief.getTotal()){
            System.out.println("the winner is: "+ thief.getAdventurerName());
        }else if (b.getTotal()>thief.getTotal()){
            System.out.println("the winner is: "+ b.getAdventurerName());
        }
    }



    public int rollTheDice(){
        dis1 = r.nextInt(6)+1;
        dis2 = r.nextInt(6)+1;
//        System.out.println("dice 1 from rollTheDice: "+dis1);
//        System.out.println("dice 2 from rollTheDice: "+dis2);
        return dis1+dis2;
    }


    public class Adventurer{}
}
