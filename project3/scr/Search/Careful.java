package Search;
import java.util.Random;
public class Careful implements Search {
    private int minDiceRoll = 4;
    private double avoidTrap = .5;
    public int getMinDiceRoll(){
        return this.minDiceRoll;
    }
    public double getAvoidTrap(){
        return this.avoidTrap;
    }
    @Override
    public Boolean search(){
        Random r = new Random();
        int roll = r.nextInt(7) + r.nextInt(7);
        if(roll > this.minDiceRoll){
            return true;
        }else{return false;}
    }
}
