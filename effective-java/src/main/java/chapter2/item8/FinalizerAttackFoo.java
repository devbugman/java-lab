package chapter2.item8;

public class FinalizerAttackFoo extends SuperFoo {

    public FinalizerAttackFoo(int value) {
        super(value);
    }

    @Override
    protected void finalize() throws Throwable {
        this.setValue(-1);
    }
}
