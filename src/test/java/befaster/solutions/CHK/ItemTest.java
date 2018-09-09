package befaster.solutions.CHK;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item test;

    @Test
    public void priceFor() {
        test = new Item("A", 20);

        assertEquals(60, test.priceFor(3).longValue());

        test.addOffer(2, 30);
    }

    @Test
    public void priceForWithOffers() {
        test = new Item("A", 20);
        test.addOffer(2, 30);

        assertEquals(50, test.priceFor(3).longValue());
    }
}