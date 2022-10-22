package Search;

import org.junit.jupiter.api.Test;
import Logger.*;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

class CarelessTest {

    @Test
    void getMinDiceRoll() {
        Careless c = new Careless();
        assertEquals(10,c.getMinDiceRoll(), "Minimum Dice Roll is 10 as expected!\n ");
        out.println("Careless Minimum Dice Roll is 10 as expected!");
    }
}