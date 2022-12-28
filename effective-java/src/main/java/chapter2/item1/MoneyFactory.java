package chapter2.item1;

public class MoneyFactory {

    public static void main(String[] args) {
        int amount = 1000;
        Money dollar = Money.of(MoneyType.DOLLAR, amount);
        System.out.println("isSameAmount(dollar.getAmount(), amount) = " + isSameAmount(dollar.getAmount(), amount));

        Money won = Money.of(MoneyType.WON, amount);
        System.out.println("isSameAmount(won.getAmount(), amount) = " + isSameAmount(won.getAmount(), amount));
    }

    private static boolean isSameAmount(int amount1, int amount2) {
        return amount1 == amount2;
    }
}
