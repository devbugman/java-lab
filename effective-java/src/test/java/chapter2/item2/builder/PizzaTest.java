package chapter2.item2.builder;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void 빌더패턴_1() {
        Calzone pizza = new Calzone.Builder()
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();

        assertThat(pizza.isSauceInside()).isTrue();
    }

    @Test
    void 빌더패턴_2() {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.LARGE)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.SAUSAGE)
                .build();

        Set<Pizza.Topping> toppings = pizza.getToppings();

        assertThat(toppings.size()).isEqualTo(3);
    }
}