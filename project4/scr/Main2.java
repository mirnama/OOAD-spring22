import Room.*;
import Logger.Publication;
public class Main2 {
    public static void main(String[] args){
    Turn t2 = new Turn();
    Publication p = new Publication(t2);
    FactoryMake f = new FactoryMake();
    // t2.startGame();
    int round = 0;
    Boolean endGame = false;
    do
    {
        t2.oneTurn();

        round++;
         t2.displayBoard();
        // System.out.print(t.checkEndConditions());
        // System.out.println(count);
        t2.printReport();

        p.update("Publisher updates: ", t2);
        endGame = t2.checkEndConditions();

    }while(round<31 && !endGame);
    
}

}
