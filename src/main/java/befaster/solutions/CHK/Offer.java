package befaster.solutions.CHK;

import javax.persistence.*;
import java.util.List;

@Entity
public class Offer implements Comparable<Offer> {
    @Id
    private Long id;

    @OneToMany
    private List<Item> items;

    @Column(name = "OFFER_SIZE")
    private Integer offerSize;

    @Column(name = "OFFER_PRICE")
    private Integer offerPrice;

    @Column(name = "OFFER_ITEM")
    private String offerItem;

    Offer(Integer offerSize, Integer offerPrice, String offerItem) {
        this.offerPrice = offerPrice;
        this.offerSize = offerSize;
        this.offerItem = offerItem;
    }

    public Offer() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItem(List<Item> items) {
        this.items = items;
    }

    public Integer getOfferSize() {
        return offerSize;
    }

    public void setOfferSize(Integer offerSize) {
        this.offerSize = offerSize;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOfferItem() {
        return offerItem;
    }

    public void setOfferItem(String offerItem) {
        this.offerItem = offerItem;
    }

    @Override
    public int compareTo(Offer o) {
        return this.offerSize.compareTo(o.offerSize);
    }
}
