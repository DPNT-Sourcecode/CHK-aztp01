package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private PriceList priceList = new PriceList(); //Depencedency injection... DB access point in the future

    public Integer checkout(String skus) {
        Map<String, Integer> basket = new HashMap<>();

        for (int x = 0; x < skus.length(); x++) {
            String key = String.valueOf(skus.charAt(x));
            if (!basket.containsKey(key)) {
                basket.put(key, 0);
            }

            basket.compute(key, (k, v) -> v + 1);
        }

        Integer sum = 0;

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            Item item = priceList.getItemDetails(entry.getKey());
            Integer itemCount = entry.getValue();

            if (item == null) return -1;

            sum += item.priceFor(itemCount);
        }
        return sum;

    }
}