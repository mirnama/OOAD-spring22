import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Turn t = new Turn();
        t.startGame();

        t.displayBoard();
        t.oneTurn();
        t.displayBoard();
    }

}
