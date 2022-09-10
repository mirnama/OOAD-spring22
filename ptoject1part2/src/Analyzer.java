import java.util.ArrayList;
import java.util.Collections;

public class Analyzer {
    double sum;
    double mean;
    double median;
    double variance, sd,x;
    public void analyze(ArrayList<Integer> data){
        for (Integer integer : data) {
            sum += integer;
        }
        mean=sum/data.size();
        System.out.println("The mean is: "+mean);
        Collections.sort(data);
        int half = data.size()/2;
        if (data.size()%2!=0){
            median = data.get(half);
        }else median = ((data.get(half - 1) + data.get(half)) / 2);
        System.out.println("Median:  "+median);
        for (int i =0;  i< data.size();i++){
            x += Math.pow(data.get(i) - mean, 2);
            System.out.println("x:"+i+"  "+x);
        }
        variance = x /data.size();

        sd = Math.sqrt(variance);
        System.out.println("Stander Deviation: "+sd);
        System.out.println("Variance:  "+variance);


    }
}


////https://www.javatpoint.com/how-to-sort-arraylist-in-java
////https://stackoverflow.com/questions/4455873/java-arraylist-to-store-user-input