package Search;
import java.util.Random;

public class Quick implements Search{
    private int minDiceRoll = 6;
    private double skipSearch = .33;
    public int getMinDiceRoll(){
        return this.minDiceRoll;
    }
    public double getSkipSearch(){
        return this.skipSearch;
    }
    @Override
    public Boolean search(){
        Random r = new Random();
        int roll = r.nextInt(7) + r.nextInt(7);
        if(r.nextInt(100) % 3 == 0){
            // skip search
            return false;
        }else{
            // search
            if( roll > this.minDiceRoll){
                return true;
            }else{return false;}
        }

    }
}
