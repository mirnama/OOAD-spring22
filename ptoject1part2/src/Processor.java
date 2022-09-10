import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Processor {
    public String read(){

        System.out.println("Enter your string");

        Scanner sca = new Scanner(System.in);

        String str = sca.nextLine();

        sca.close();
        str = str.replaceAll("\\s", "");
        return str;
    }
    public String sort(String str){
        str = str.toUpperCase();
        char strTemp [] = str.toCharArray();
        Arrays.sort(strTemp);
        return new String(strTemp);
    }

    public static void main(String[] args) {

        Processor p = new Processor();
        String stb = p.read();
        String after = p.sort(stb);
        System.out.println("The new String is: "+after);
    }
}




//https://www.javatpoint.com/java-string-replaceall