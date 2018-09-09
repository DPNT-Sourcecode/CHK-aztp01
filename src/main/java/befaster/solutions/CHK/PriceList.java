package befaster.solutions.CHK;

public enum PriceList {
    A(50, 3, 130),
    B(30, 2, 45),
    C(20, 1, 20),
    D(15, 1, 15);

    private int price;

    private int offer;

    private int offerPrice;

    PriceList(int price, int offer, int offerPrice) {
        this.price = price;
        this.offer = offer;
        this.offerPrice = offerPrice;

    }

    public int getOffer() {
        return offer;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public int getPrice() {
        return price;
    }
}