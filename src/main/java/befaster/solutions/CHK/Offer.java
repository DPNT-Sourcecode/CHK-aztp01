package befaster.solutions.CHK;

import javax.persistence.*;
import java.util.*;

@Entity
public class Offer implements Comparable<Offer> {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name="Item_Offer",
            joinColumns={@JoinColumn(name="offers_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="Item_name", referencedColumnName="name")})
    private List<Item> items;

    @Column(name = "OFFER_SIZE")
    private Integer offerSize;

    @Column(name = "OFFER_PRICE")
    private Integer offerPrice;

    @Column(name = "OFFER_ITEM")
    private String offerItem;

    public Offer() {
    }

    Offer(Integer offerSize, Integer offerPrice, String offerItem) {
        this.offerPrice = offerPrice;
        this.offerSize = offerSize;
        this.offerItem = offerItem;
    }

    public Integer applyOffer(Map<String, Integer> basket) {
        List<Item> copy = new ArrayList<>();
        //Collections.copy(items, copy);
        int finalPrice = 0;
        //int notAccounted = 0;

        items.sort(Comparator.comparingInt(Item::getPrice));

        for(Item item : items) {
            Integer itemCount = basket.get(item.getName());
            if (itemCount != null && itemCount > 0) {
                int offerCount = itemCount / offerSize;

                finalPrice += offerCount * offerPrice;
                itemCount -= offerCount;

                basket.replace(item.getName(), itemCount);
                basket.compute(offerItem, (k, v) -> (v == null || v < offerCount) ? 0 : v - offerCount);
            }
        }


        return finalPrice;
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
