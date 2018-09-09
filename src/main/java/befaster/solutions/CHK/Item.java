package befaster.solutions.CHK;

import java.util.LinkedList;
import java.util.List;

public class Item {
    private String name;
    private Integer price;
    private List<Offer> offers;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.offers = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void addOffer(Integer size, Integer price) {
        offers.add(new Offer(size, price));
    }

    public Integer priceFor(int num) {
        return 0;
    }

    private class Offer implements Comparable<Offer> {
        private Integer offerSize;
        private Integer offerPrice;

        Offer(Integer offerSize, Integer offerPrice) {
            this.offerPrice = offerPrice;
            this.offerSize = offerSize;
        }

        public Integer getOfferSize() {
            return offerSize;
        }

        public Integer getOfferPrice() {
            return offerPrice;
        }


        @Override
        public int compareTo(Offer o) {
            return this.offerSize.compareTo(o.offerSize);
        }
    }

}