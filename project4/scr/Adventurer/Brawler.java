package Adventurer;
import combat.*;
import Search.*;
public class Brawler extends Adventurer{
    private Combat combat;
    private Search searchType;
    private int maxDamage = 12;

    public Brawler(String newName,String type,int[] newPos) {
        super(newName,type, newPos);
        this.combat = new Expert();
        this.searchType = new Careless();
        
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
