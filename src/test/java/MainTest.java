import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
    @Test
    public void testMainSuccess() {
        //ARRANGE
        Main main = new Main("TestMain");

        //ACT
        String name = main.getName();

        //ASSERT
        assertEquals("TestMain", name);
    }

    @Test
    public void testMainFail() {
        //ARRANGE
        Main main = new Main("TestMain");

        //ACT
        String name = "SomeVeryDifferentString";

        //ASSERT
        assertEquals("TestMain", name);
    }
}
