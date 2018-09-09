package befaster.solutions.CHK;

public enum PriceList {
    A(50),
    B(30),
    C(20),
    D(15);

    private int price;

    PriceList(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}