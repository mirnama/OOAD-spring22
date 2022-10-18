package Search;
import java.util.Random;
public class Careless implements Search {
    private int minDiceRoll = 10;

    public int getMinDiceRoll(){
        return this.minDiceRoll;
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
