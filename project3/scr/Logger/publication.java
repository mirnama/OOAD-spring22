package Logger;

import Adventurer.Adventurer;

public class publication implements Observer, Logger {

    public publication() {
        Adventurer a;
    }


    @Override
    public void update(String s) {
        out("");
    }
}
