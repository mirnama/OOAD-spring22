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
    
}
