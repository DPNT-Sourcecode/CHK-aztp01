package befaster.solutions.CHK;

import java.util.Comparator;
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

    public void addOffer(Integer size, Integer price, String offerItem) {
        offers.add(new Offer(size, price, offerItem));
    }

    public Integer priceFor(int num) {
        int remain = num;
        Integer sum = 0;

        offers.sort(Comparator.reverseOrder());

        for (Offer offer : offers) {
            int onOffer = remain / offer.getOfferSize();
            sum += onOffer * offer.getOfferPrice();
            remain -= offer.getOfferSize() * onOffer;
        }

        return sum + remain * price;
    }

    public String getOfferItems(int num) {
        int remain = num;
        StringBuffer res = new StringBuffer();

        offers.sort(Comparator.reverseOrder());

        for (Offer offer : offers) {

            int onOffer = remain / (offer.getOfferSize() + (offer.getOfferItem().equals(name)? 1 : 0));

            for (int x = 0; x < onOffer; x++) {
                res.append(offer.getOfferItem());
            }

            remain -= offer.getOfferSize() * onOffer;
        }

        return res.toString();
    }

    private class Offer implements Comparable<Offer> {
        private Integer offerSize;
        private Integer offerPrice;
        private String offerItem;

        Offer(Integer offerSize, Integer offerPrice, String offerItem) {
            this.offerPrice = offerPrice;
            this.offerSize = offerSize;
            this.offerItem = offerItem;
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

        public String getOfferItem() {
            return offerItem;
        }
    }

}
