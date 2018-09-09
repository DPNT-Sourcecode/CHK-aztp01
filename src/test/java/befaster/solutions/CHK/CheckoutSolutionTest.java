package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {
    private CheckoutSolution test;

    @Before
    public void setUp() throws Exception {
        test = new CheckoutSolution();
    }


    /*
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
 */

    @Test
    public void checkout() {
        Integer returnedValue = test.checkout("ABBACAD");
        assertEquals(210L, returnedValue.longValue());

        returnedValue = test.checkout("ABBaCAD");
        assertEquals(-1L, returnedValue.longValue());

        returnedValue = test.checkout("AxD");
        assertEquals(-1L, returnedValue.longValue());

        returnedValue = test.checkout("AAEEB");
        assertEquals(180L, returnedValue.longValue());
    }

    @Test
    public void checkout2() {
        Integer returnedValue = test.checkout("ABCDE");
        assertEquals(155L, returnedValue.longValue());

        returnedValue = test.checkout("EEEEBB");
        assertEquals(160L, returnedValue.longValue());

        returnedValue = test.checkout("BEBEEE");
        assertEquals(160L, returnedValue.longValue());
    }
}