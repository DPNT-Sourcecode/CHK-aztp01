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
        //List<Item> copy = new ArrayList<>();
        //Collections.copy(items, copy);
        int finalPrice = 0;
        List<Item> remains = new ArrayList<>();

        items.sort(Comparator.comparingInt(Item::getPrice));

        for(Item item : items) {
            String itemId = item.getName();
            Integer itemCount = basket.get(itemId);
            if (itemCount != null && itemCount > 0) {
                int offerCount = (itemCount+remains.size()) / (offerSize + (offerItem.equals(itemId)?1:0));
                if(offerCount > 0 ) {

                    if (!offerItem.equals("")) { //Remove free items
                        basket.compute(offerItem, (k, v) -> (v == null || v < 1) ? 0 : v - offerCount);
                    }

                    finalPrice += offerCount * offerPrice;

                    int offeredItems = (offerSize * offerCount) - remains.size();

                    basket.compute(itemId, (k, v) -> v - offeredItems);

                    for (int x = 0; x < remains.size(); x++) {
                        Item removableItem = remains.get(x);
                        basket.compute(removableItem.getName(), (k, v) -> v - 1);
                    }

                    remains.clear();

                    for (int x = 0; x < basket.get(itemId); x++) {
                        remains.add(item); //create a list of items that can still make a group offer
                    }

                }
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