package chapter2.item1;

public class Dollar implements Money {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
