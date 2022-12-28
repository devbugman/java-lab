package chapter2.item1;

public class FooSingleton {
    private static final FooSingleton INSTANCE = new FooSingleton();

    private FooSingleton() {
    }

    public static FooSingleton getInstance() {
        return INSTANCE;
    }
}
