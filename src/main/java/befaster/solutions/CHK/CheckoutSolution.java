package befaster.solutions.CHK;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;

public class CheckoutSolution {

    private EntityManager em;

    public CheckoutSolution() {
        em = Persistence.createEntityManagerFactory("CheckoutPrices").createEntityManager();
    }

    public Integer checkout(String skus) {
        Map<String, Integer> basket = new HashMap<>();


        for (int x = 0; x < skus.length(); x++) {
            String key = String.valueOf(skus.charAt(x));

            basket.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
        }

        Map<String, Integer> remain = new HashMap<>(basket);

        Integer finalPrice = 0;
        List<Offer> offers = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            Item item = em.find(Item.class, entry.getKey()); //priceList.getItemDetails(entry.getKey());
            Integer itemCount = entry.getValue();

            if (item == null) return -1;

            offers.addAll(item.getOffers());

            //String offerItems = item.getOfferItems(itemCount);

            //applyOffer(basket, offerItems);
        }

        offers.sort((o1, o2) -> (o1.getOfferItem().equals(""))? (o1.getOfferSize() - o2.getOfferSize()) : Integer.MIN_VALUE);
        for(Offer offer : offers) {
            finalPrice += offer.applyOffer(remain);
        }

        return finalPrice + calculateFinalPrice(remain);
    }

    private void applyOffer(Map<String, Integer> basket, String offerItems) {
        for (int x = 0; x < offerItems.length(); x++) {
            String key = String.valueOf(offerItems.charAt(x));
            basket.compute(key, (k, v) -> (v == null) ? 0 : v - 1);
        }
    }

    private Integer calculateFinalPrice(Map<String, Integer> basket) {
        Integer sum = 0;

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            Item item = em.find(Item.class, entry.getKey()); //priceList.getItemDetails(entry.getKey());
            Integer itemCount = entry.getValue();

            if (item == null) return -1;

            sum += item.priceFor(itemCount);
        }

        return sum;
    }
}
