package Adventurer;
import Logger.Logger;
import Search.*;
import Room.*;
import combat.*;
import Search.*;
import Room.Treasures;
import java.util.ArrayList;


public abstract class Adventurer implements Logger {
    private int[] currentPosition= {0,0,0};
    private ArrayList<Treasures> Loot;
    private String adventurerName;
    private String type;
    private int treasure=0;
    private int damage=0;

    public Adventurer( String newName,String type, int[] newPos){
        this.adventurerName = newName;
        this.type =type;
        this.currentPosition = newPos;
    }
    public String getType(){
        return this.type;
    }
    public int[] getCurrentPosition(){
        return this.currentPosition;
    }
    public void setCurrentPosition(Integer i, Integer j, Integer k){
        this.currentPosition[0] = i;
        this.currentPosition[1] = j;
        this.currentPosition[2] = k;
    }
    public void setCurrentPosition(int[] id){
        this.currentPosition = id;
    }
    public int getTreasure(){
        return this.treasure;
    }
    public void addTreasure(){
        this.treasure++;
    }
    public int getDamage(){
        return this.damage;
    }
    public void takeDamage(){
        this.damage++;
    }
    
    public String fight(){return "";}
    public Boolean search(){return false;}

    //  public boolean search(){
    //      Turn t = new Turn();
    //      if(t.rollTheDice() >= 10){
    //          return true;
    //      }else{
    //          return false;
    //      }
    //  }
    public String getAdventurerName(){
        return this.adventurerName;
    }
    public void addLoot(Treasures t){
        this.Loot.add(t);
    }
   public Boolean allLootTypes(){
        long count = this.Loot.stream().distinct().count();
        if(count == 6){
            return true;
        }
        else{return false;}
   }
    
}
