public class Turn extends Game{
    public String fight(){
        int aDice = this.rollTheDice();
        int cDice = this.rollTheDice();
        if(aDice > cDice){
            return("Adventurer");
        }else if(cDice > aDice){
            return("Creature");
        }else{
            return("Tie");
        }
    }
    public boolean search(){
        if(this.rollTheDice() >= 10){
            return true;
        }else{
            return false;
        }
    }
    
}