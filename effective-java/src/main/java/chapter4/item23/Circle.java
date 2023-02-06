package chapter4.item23;

public class Circle extends Figure {
    final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
