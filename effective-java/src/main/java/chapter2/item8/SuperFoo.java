package chapter2.item8;

public class SuperFoo {
    private int value;

    public SuperFoo(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수가 들어올 수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        System.out.println("값 변경 = " + value);
        this.value = value;
    }
}
