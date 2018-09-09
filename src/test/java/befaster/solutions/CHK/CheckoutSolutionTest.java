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

    @Test
    public void checkout() {
        Integer returnedValue = test.checkout("ABBACAD");
        assertEquals(210L, returnedValue.longValue());

        returnedValue = test.checkout("ABBaCAD");
        assertEquals(-1L, returnedValue.longValue());

        returnedValue = test.checkout("AxD");
        assertEquals(-1L, returnedValue.longValue());
    }
}
