import java.util.ArrayList;
public class Creature{
    private String creatureName;
    private int[] currentPosition;
    public Creature(String type, int[]newPos){
        this.creatureName = type;
        this.currentPosition = newPos;
    }
    public String getCreatureName(){
        return this.creatureName;
    }
    public void setCreatureName(String type){
        this.creatureName= type;
    }
    public int[] getCurrentPosition(){
        return this.currentPosition;
    }
    public void setCurrentPosition(Integer i, Integer j, Integer k){
        this.currentPosition[0] = i;
        this.currentPosition[1] = j;
        this.currentPosition[2] = k;
    }
    public void setCurrentPosition(int[] newPos){
        this.currentPosition= newPos;
        
    }
    public void move() {
    }
}

