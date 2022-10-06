import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader(); // instantiate the objects
        Analyzer analyzer = new Analyzer();
        ArrayList<Integer> data = reader.readInput(); // read data from the user
        analyzer.analyze(data); // perform all calculations


        System.out.println("Good Bye");
    }
}