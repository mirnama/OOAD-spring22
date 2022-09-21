import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Brawler b = new Brawler();
        Thief thief = new Thief();
        System.out.println("Name "+b.getAdventurerName());

//        System.out.printf("Adventure is: %d", b.getAdventurerName());
        System.out.printf("Adventure total is: %d\n",  b.getTotal());
        System.out.println("Name "+thief.getAdventurerName());
        System.out.printf("Adventure total is: %d\n",  thief.getTotal());
        Game g = new Game();
        if(b.getTotal()< thief.getTotal()){
            System.out.println("the winner is: "+ thief.getAdventurerName());
        }else if (b.getTotal()>thief.getTotal()){
            System.out.println("the winner is: "+ b.getAdventurerName());
        }
//        g.rollTheDice();
//        System.out.println("Dice1 rolled:  "+g.getDis1());
//        System.out.println("Dice2 rolled:  ");
//        System.out.println("total Dice rolled:  "+g.rollTheDice());
    }
}