package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<String, Integer> itemCount = new HashMap<>();

        for (int x = 0; x < skus.length(); x++) {
            String key = String.valueOf(skus.charAt(x));
            if(!itemCount.containsKey(key)){
                itemCount.put(key, 0);
            }

            itemCount.compute(key, (k,v) -> v+1);
        }

        int sum = 0;

        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            sum += entry.getValue();
        }

        return sum;
    }
}
