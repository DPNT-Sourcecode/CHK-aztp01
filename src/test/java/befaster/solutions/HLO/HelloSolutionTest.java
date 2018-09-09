package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloSolutionTest {
    private HelloSolution test;

    @Before
    public void setUp() throws Exception {
        test = new HelloSolution();
    }

    @Test
    public void hello() {
        assertEquals(test.hello("Friend"), "Hello World!");
    }
}