package chapter3.item10.transivity;

import java.util.Objects;

public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(final int x, final int y, final Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        final ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}
