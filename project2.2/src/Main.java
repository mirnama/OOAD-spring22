//this is the main to start one turn. it will spawn in the temple 
//and adventures and creatures and show one turn of movement
public class Main {
    public static void main(String[] args) {
        //for one turn
        Turn t = new Turn();
        t.startGame();

        t.displayBoard();
        // Boolean endGame = false;
        // int count =0;
    
        t.oneTurn();
        // count++;
        t.displayBoard();
        // System.out.print(t.checkEndConditions());
        // System.out.println(count);
        // endGame = t.checkEndConditions();
        
        
        // System.out.println("It took: "+count+ " Turns");

        
        
        
       
        
    }}
    
