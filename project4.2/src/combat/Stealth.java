package combat;

import java.util.Random;
public class Stealth implements Combat{
    private int diceBonus =0;
    private double avoidFight = .5;
    public int getDiceBonus(){
        return this.diceBonus;
    }
    public double getAvoidFight(){
        return this.avoidFight;
    }
    @Override
    public String fight(){
        Random r = new Random();
        if(r.nextInt(100) % 2 == 0){
            // avoid fight
            return("N");
        }else{
            //fight
            
            int cRoll = r.nextInt(7);
            int aRoll = r.nextInt(7);
            String loser ="";
            if(aRoll> cRoll){
                //creature dead
                loser ="c";
                // System.out.println(c.getCreatureName() + " was Killed by " +a.getType());
                // this.creaturesInRoom.remove(c);
            }else if(cRoll > aRoll){
                //adventurer damage
                loser = "a";
                // a.takeDamage();
                // System.out.println(a.getType() + " was hurt by "+ c.getCreatureName());
            }else if(aRoll == cRoll){
                //tie
                loser = "t";
                // System.out.println(a.getType() + " and "+ c.getCreatureName()+ " Tied");
            }
            return loser;
             
            
        }
    }
}
