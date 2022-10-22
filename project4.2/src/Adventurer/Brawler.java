package Adventurer;
import combat.*;
import Search.*;
public class Brawler extends Adventurer{
    private Combat combat;
    private Search searchType;

    public Brawler(String newName,String type,int[] newPos) {
        super(newName,type, newPos);
        this.combat = new Expert();
        this.searchType = new Careless();
        
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
