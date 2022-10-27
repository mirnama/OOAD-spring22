//I used this from the class example
package Logger;
public interface Logger {

    default void out(String msg){System.out.println(msg);}
}
