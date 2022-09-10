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
        int minValu = data.get(0);
        int maxValu = data.get(0);
        System.out.println("The mean is: "+mean);
        Collections.sort(data);
        int half = data.size()/2;
        if (data.size()%2!=0){
            median = data.get(half);
        }else median = ((data.get(half - 1) + data.get(half)) / 2);
        System.out.println("Median:  "+median);
        for (int i =0;  i< data.size();i++){
            x += Math.pow(data.get(i) - mean, 2);

            if (data.get(i)> maxValu){
                maxValu = data.get(i);

            }else if (data.get(i)< minValu){
                minValu = data.get(i);
            }

        }

        variance = (x /data.size());
        sd = Math.sqrt(variance);
        System.out.println("Stander Deviation: "+sd);
        System.out.println("Variance:  "+variance);
        System.out.println("Maximum Value: "+maxValu);
        System.out.println("Minimum Value:  "+minValu);



    }


}


////https://www.javatpoint.com/how-to-sort-arraylist-in-java
////https://stackoverflow.com/questions/4455873/java-arraylist-to-store-user-input
//https://www.programiz.com/java-programming/examples/standard-deviation