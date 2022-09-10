import java.lang.reflect.Array;
import java.util.*;

public class Reader {

    double mean;
    double median;
    double sd = 0.0;
    double sum;
    double variance;
    double x;
    ArrayList<Integer> myNum= new ArrayList<>();



    public void readInput() {

//        System.out.println("Enter you number");
//        System.out.println("Enters a null input to exit");
        boolean inp = true;
        Scanner numInp = new Scanner(System.in);


        while (inp) {
            System.out.println("Enter you number");
            System.out.println("Enters a null input to exit");

            String nextnum = numInp.nextLine();
            if (nextnum.isEmpty()){
                inp = false;
                continue;
            }
            int num = Integer.parseInt(nextnum);

            myNum.add(num);
            }

    }
    public void printArry(){
        System.out.println(myNum);
//        for (int i : myNum){
//            System.out.println(i);
//        }

    }
    public void  myMean(){
        for (Integer integer : myNum) {
            sum += integer;
        }
        System.out.println("The sum is: "+sum);
        median=sum/myNum.size();
        System.out.println("The median is: "+median);
    }
    public void myMedian(){
        Collections.sort(myNum);
        System.out.println("After sorting: "+myNum);
        int half = myNum.size()/2;
        if (myNum.size()%2!=0){
            median = myNum.get(half);
            System.out.println("Median:  "+median);
        }else {
            median = ((myNum.get(half-1)+myNum.get(half))/2);
            System.out.println("Median:  "+median);


        }
    }
    public void calSD(){
        for (int i =0;  i< myNum.size();i++){
            x += Math.pow(myNum.get(i) - mean, 2);
            System.out.println("x:"+i+"  "+x);
        }
        variance = x /myNum.size();

        sd = Math.sqrt(variance);
        System.out.println("Stander Deviation: "+sd);
        System.out.println("Variance:  "+variance);
    }

}
//https://www.javatpoint.com/how-to-sort-arraylist-in-java
//https://stackoverflow.com/questions/4455873/java-arraylist-to-store-user-input