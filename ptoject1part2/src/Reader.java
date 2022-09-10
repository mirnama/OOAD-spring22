import java.util.*;

public class Reader {

    ArrayList<Integer> myNum= new ArrayList<>();



    public ArrayList<Integer> readInput() {

        System.out.println("Enter you number");
        System.out.println("Enters a null input to exit");
        boolean inp = true;
        Scanner numInp = new Scanner(System.in);


        while (inp) {
            String nextnum = numInp.nextLine();
            if (nextnum.isEmpty()){ // break the while loop if the input in empty
                inp = false;
                continue;
            }
            int num = Integer.parseInt(nextnum); // turn the input from string into integer

            myNum.add(num); // add the new entry into the array list
            }
        System.out.println("Numbers entered: "+myNum);
        return myNum;
    }

}
//https://www.javatpoint.com/how-to-sort-arraylist-in-java
//https://stackoverflow.com/questions/4455873/java-arraylist-to-store-user-input