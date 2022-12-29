package chapter2.item2.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }
    private final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {// 재귀적인 타입 매개변수
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이메서드를 재정이
        // this를 반환
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public Set<Topping> getToppings() {
        return toppings;
    }
}
