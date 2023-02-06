package chapter4.item23;

/**
 * 사각형
 */
public class Rectangle extends Figure {
    final double length;
    final double width;

    public Rectangle(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
