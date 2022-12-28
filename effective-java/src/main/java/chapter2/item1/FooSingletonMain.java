package chapter2.item1;

public class FooSingletonMain {
    public static void main(String[] args) {
        FooSingleton instance1 = FooSingleton.getInstance();
        FooSingleton instance2 = FooSingleton.getInstance();
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        System.out.println("(instance1 == instance2) = " + (instance1 == instance2));
    }
}
