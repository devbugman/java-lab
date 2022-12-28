package chapter2.item1;

public interface Money {
    int getAmount();

    static Money of(MoneyType type, int amount) {
        if (MoneyType.DOLLAR == type) {
            return new Dollar(amount);
        }

        if (MoneyType.WON == type) {
            return new Won(amount);
        }
        throw new IllegalArgumentException();
    }
}
