package Logger;

import Adventurer.Adventurer;

public class Publication implements Observer, Logger {

    public Publication() {
        Adventurer a;
    }


    @Override
    public void update(String s) {
        out("");
    }
}
