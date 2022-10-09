package Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import Creature.*;
import Adventurer.*;
import Logger.Logger;
import Room.*;

public interface Observer  {
    public abstract void update( String s);
}
