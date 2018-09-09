package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<String, Integer> basket = new HashMap<>();

        for (int x = 0; x < skus.length(); x++) {
            String key = String.valueOf(skus.charAt(x)).toUpperCase();
            if(!basket.containsKey(key)){
                basket.put(key, 0);
            }

            basket.compute(key, (k,v) -> v+1);
        }

        Integer sum = 0;

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            PriceList item = PriceList.valueOf(entry.getKey());
            Integer itemCount = entry.getValue();
            int offerCount = itemCount / item.getOffer();
            int nonOffer = itemCount % item.getOffer();

            sum += nonOffer * item.getPrice() + offerCount * item.getOfferPrice();
        }

        return sum;
    }
}