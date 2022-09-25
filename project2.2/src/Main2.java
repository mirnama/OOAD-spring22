public class Main2 {
    //This main is to run the gam for 30 turns or until the game ends on its own
    public static void main(String[] args){
    Turn t2 = new Turn();
    t2.startGame();
    int round = 0;
    Boolean endGame = false;
    do
    {
        t2.oneTurn();
        round++;
        // t.displayBoard();
        // System.out.print(t.checkEndConditions());
        // System.out.println(count);
        t2.printReport();
        endGame = t2.checkEndConditions();

    }while(round<31 && !endGame);
    
}

}
