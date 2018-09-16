package befaster.solutions.CHK;

import javax.persistence.Entity;

@Entity
public class Offer implements Comparable<Offer> {
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