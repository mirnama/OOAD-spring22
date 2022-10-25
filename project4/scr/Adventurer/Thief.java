package Adventurer;
import combat.*;
import Search.*;
public class Thief extends Adventurer{
    private Combat combat;
    private Search searchType;
    private int maxDamage = 10;
    public Thief(String newName,String type,int[] newPos) {
        super(newName,type, newPos);
        this.combat = new Trained();
        this.searchType = new Careful();
    }
    public boolean isDead(){
        if (this.getDamage() > maxDamage){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String fight(){
        return combat.fight();
    }
    @Override
    public Boolean search(){
        return searchType.search();
    }
}
