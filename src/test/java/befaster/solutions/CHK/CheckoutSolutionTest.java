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

        returnedValue = test.checkout("FFFFFF");
        assertEquals(40L, returnedValue.longValue());

    }

    @Test
    public void testGroupOffer1Item(){
        Integer returnedValue = test.checkout("SSS");
        assertEquals(45L, returnedValue.longValue());

        returnedValue = test.checkout("SSSS");
        assertEquals(65L, returnedValue.longValue());

        returnedValue = test.checkout("SSSSSS");
        assertEquals(90L, returnedValue.longValue());
    }

    @Test
    public void testGroupOffer2Item(){
        Integer returnedValue = test.checkout("SSST");
        assertEquals(65L, returnedValue.longValue());

        returnedValue = test.checkout("SSSSTT");
        assertEquals(90L, returnedValue.longValue());

        returnedValue = test.checkout("SSSSTTTTT");
        assertEquals(135L, returnedValue.longValue());
    }

    @Test
    public void testGroupOffer3Item(){
        Integer returnedValue = test.checkout("SSSTX");
        assertEquals(82L, returnedValue.longValue());

        returnedValue = test.checkout("SSSSTTX");
        assertEquals(107L, returnedValue.longValue());

        returnedValue = test.checkout("STX");
        assertEquals(45L, returnedValue.longValue());
    }
}