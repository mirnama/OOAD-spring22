public class Adventurer {
    private int[] currentPosition= {0,0,0};
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

    public boolean search(){
        Turn t = new Turn();
        if(t.rollTheDice() >= 10){
            return true;
        }else{
            return false;
        }
    }
    public String getAdventurerName(){
        return this.adventurerName;
    }

}
