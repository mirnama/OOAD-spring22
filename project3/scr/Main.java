import javax.swing.text.html.StyleSheet;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;

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

        
        
        
       
        
    }
}
