package befaster.solutions.CHK;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private PriceList priceList = new PriceList(); //Depencedency injection... DB access point in the future
    private  EntityManagerFactory emf;

    public CheckoutSolution() {
        emf = Persistence.createEntityManagerFactory("CheckoutPrices");
        
    }
    public Integer checkout(String skus) {
        Map<String, Integer> basket = new HashMap<>();

        for (int x = 0; x < skus.length(); x++) {
            String key = String.valueOf(skus.charAt(x));

            basket.compute(key, (k, v) ->  (v == null)? 1 : v + 1);
        }

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            Item item = priceList.getItemDetails(entry.getKey());
            Integer itemCount = entry.getValue();

            if (item == null) return -1;

            String offerItems = item.getOfferItems(itemCount);

            applyOffer(basket, offerItems);
        }

        return calculateFinalPrice(basket);
    }

    private void applyOffer(Map<String, Integer> basket, String offerItems) {
        for(int x = 0; x < offerItems.length(); x++) {
            String key = String.valueOf(offerItems.charAt(x));
            basket.compute(key, (k, v) -> (v == null)? 0 : v - 1);
        }
    }

    private Integer calculateFinalPrice(Map<String, Integer> basket) {
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
