package chapter2.item8;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Item8Test {

    @Test
    void clean_1() throws Exception {
        try (var Room = new Room()) {
            System.out.println("실행");
        }
    }

    @Test
    void clean_2() {
        new Room();
        System.out.println("실행");
    }

    @Test
    @DisplayName("일반적으로 예외가 발생할 경우")
    void exception() {
        assertThatThrownBy(() -> new SuperFoo(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("finalizer 공격")
    void finalizerAttack() throws InterruptedException {
        SuperFoo foo = null;
        try {
            foo = new FinalizerAttackFoo(-1);
        } catch (Exception e) {
            System.out.println(-1 + "값은 들어갈 수가 없는데 ..");
        }
        System.gc();
        Thread.sleep(3000);
    }
}
