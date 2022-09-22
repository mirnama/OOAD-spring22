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

        System.out.printf("Adventure Name is %s Adventure Dice total is: %d\n", b.getAdventurerName(),  b.getTotal());

        System.out.printf("Adventure name is %s Dice  total is: %d\n", thief.getAdventurerName(),  thief.getTotal());

        System.out.printf("Creature name is %s Dice  total is: %d\n", creature.getCreatureName(),  creature.getTotal());
        if(b.getTotal()< creature.getTotal()){

            b.points-=1;
            b.damage+=1;
            System.out.printf("%s - %d Damage",creature.getCreatureName(), b.damage);
        }else if (b.getTotal()>creature.getTotal()){

            b.treasure+=1;
            System.out.printf("%s - %d Treasure",b.getAdventurerName(), b.treasure);
        }
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


    public class Adventurer{}
}
