package chapter2.item1;

public class Won implements Money{

    private int amount;

    public Won(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
