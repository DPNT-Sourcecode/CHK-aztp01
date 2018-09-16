package befaster.solutions.CHK;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Offer implements Comparable<Offer> {
    @Id
    private Long id;

    private Integer offerSize;
    private Integer offerPrice;
    private String offerItem;

    Offer(Integer offerSize, Integer offerPrice, String offerItem) {
        this.offerPrice = offerPrice;
        this.offerSize = offerSize;
        this.offerItem = offerItem;
    }

    public Offer() {
    }

    public void setOfferSize(Integer offerSize) {
        this.offerSize = offerSize;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    public void setOfferItem(String offerItem) {
        this.offerItem = offerItem;
    }


    public Integer getOfferSize() {
        return offerSize;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public String getOfferItem() {
        return offerItem;
    }

    @Override
    public int compareTo(Offer o) {
        return this.offerSize.compareTo(o.offerSize);
    }
}