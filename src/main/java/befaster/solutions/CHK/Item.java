package befaster.solutions.CHK;

import javax.persistence.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Item {
    @Id
    private String name;
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Offer> offers;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.offers = new LinkedList<>();
    }

    public Item() {
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




}
