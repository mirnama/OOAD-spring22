package combat;
import java.util.Random;
public class Trained implements Combat {
    private int diceBonus = 1;

    public int getDiceBonus() {
        return this.diceBonus;
    }

    @Override
    public String fight() {
        Random r = new Random();
        int cRoll = r.nextInt(7);
        int aRoll = r.nextInt(7);
        aRoll += this.diceBonus;
        String loser = "";
        if (aRoll > cRoll) {
            // creature dead
            loser = "c";
            // System.out.println(c.getCreatureName() + " was Killed by " + a.getType());
            // this.creaturesInRoom.remove(c);
        } else if (cRoll > aRoll) {
            // adventurer damage
            loser = "a";
            // a.takeDamage();
            // System.out.println(a.getType() + " was hurt by " + c.getCreatureName());
        } else if (aRoll == cRoll) {
            // tie
            loser = "t";
            // System.out.println(a.getType() + " and " + c.getCreatureName() + " Tied");
        }
        return loser;
    }
}
