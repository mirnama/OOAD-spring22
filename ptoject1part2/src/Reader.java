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
            if (nextnum.isEmpty()){
                inp = false;
                continue;
            }
            int num = Integer.parseInt(nextnum);

            myNum.add(num);
            }
        System.out.println(myNum);
        return myNum;
    }
    public void printArry(){
        System.out.println(myNum);

    }

}
//https://www.javatpoint.com/how-to-sort-arraylist-in-java
//https://stackoverflow.com/questions/4455873/java-arraylist-to-store-user-input