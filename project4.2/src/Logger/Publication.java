package Logger;

import Adventurer.Adventurer;
import Room.Turn;

import java.io.File;
import java.io.FileWriter;

import static java.awt.SystemColor.info;

public class Publication implements Observer, Logger {
    Turn t = new Turn();
    public Publication(Turn t2) {
        Adventurer a;

    }
    

    @Override
    public void update(String s, Turn t) {

        try {
            FileWriter outPut = new FileWriter("output1.txt", true);
            outPut.write("\n Publisher updates1: "+t+"\n" );
            outPut.close();;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        out("Publisher updates: "+ toString(t));
    }

    private String toString(Turn t) {
        return t.toString();
    }
}
