package Adventurer;
import combat.*;
import Search.*;
public class Thief extends Adventurer{
    private Combat combat;
    private Search searchType;
    public Thief(String newName,String type,int[] newPos) {
        super(newName,type, newPos);
        this.combat = new Trained();
        this.searchType = new Careful();
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
