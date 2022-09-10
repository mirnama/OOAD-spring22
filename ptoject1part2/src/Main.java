import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        Analyzer analyzer = new Analyzer();
        ArrayList<Integer> data = reader.readInput();
        analyzer.analyze(data);

        System.out.println("Good Bye");
    }
}