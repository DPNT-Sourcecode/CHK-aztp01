package befaster.solutions.CHK;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item test;

    @Test
    public void priceFor() {
        test = new Item("A", 20);

        assertEquals(60, test.priceFor(3).longValue());

        test.addOffer(2, 30, "");
    }

    @Test
    public void priceForWithOneOffer() {
        test = new Item("A", 20);
        test.addOffer(2, 30, "");

        assertEquals(50, test.priceFor(3).longValue());
    }

    @Test
    public void priceForWithMultiOffers() {
        test = new Item("A", 20);
        test.addOffer(2, 30, "");
        test.addOffer(5, 70, "");

        assertEquals(90, test.priceFor(6).longValue());
        assertEquals(100, test.priceFor(7).longValue());
        assertEquals(120, test.priceFor(8).longValue());
    }
}