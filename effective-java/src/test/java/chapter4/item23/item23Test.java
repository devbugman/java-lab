package chapter4.item23;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class item23Test {


    @Test
    void 사각형_test() {
        final Figure rectangle = new Rectangle(10, 10);
        assertThat(rectangle.area()).isEqualTo(100.0);
    }

    @Test
    void 원_test() {
        final Figure circle = new Circle(3);
        assertThat(circle.area()).isEqualTo(28.274333882308138);
    }

    @Test
    void 정사각형_test() {
        final Figure square = new Square(10);
        assertThat(square.area()).isEqualTo(100.0);
    }
}