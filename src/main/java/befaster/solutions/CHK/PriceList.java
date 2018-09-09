package befaster.solutions.CHK;

public enum PriceList {
    A(50, 3, 130),
    B(30, 2, 45),
    C(20, 1, 20),
    D(15, 1, 20);

    private int price;

    PriceList(int price, int special, int newPrice) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
