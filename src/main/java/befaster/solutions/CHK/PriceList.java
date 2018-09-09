package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private Map<String, Item> prices = new HashMap<>();

    public PriceList() {
        Item item = new Item("A", 50);
        item.addOffer(3,130, "");
        item.addOffer(5,200, "");

        prices.put(item.getName(), item);

        item = new Item("B", 30);
        item.addOffer(2,45, "");
        item.addOffer(5,200, "");

        prices.put(item.getName(), item);

        item = new Item("C", 20);

        prices.put(item.getName(), item);

        item = new Item("D", 15);

        prices.put(item.getName(), item);

        item = new Item("E", 40);
        item.addOffer(2,80, "B");

        prices.put(item.getName(), item);

        item = new Item("F", 10);
        item.addOffer(2,20, "F");

        prices.put(item.getName(), item);

    }

    public Item getItemDetails(String name) {
        return prices.get(name);
    }
}
