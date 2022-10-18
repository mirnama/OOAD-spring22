package Adventurer;
import combat.*;
import Search.*;
public class Runner extends Adventurer{
    private Combat combat;
    private Search searchType;
    public Runner(String newName,String type,int[] newPos) {
        super(newName,type, newPos);
        this.combat = new Stealth();
        this.searchType = new Quick();
        
    }
    
}
