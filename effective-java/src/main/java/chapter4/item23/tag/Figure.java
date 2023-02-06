package chapter4.item23.tag;

public class Figure {

    enum Shape {RECTANGLE, CIRCLE,}

    final Shape shape;

    // 다음 필드들은 모양이 사각형(RECTANGLE) 일때 만 쓰인다.
    double length;
    double width;

    // 다음필드는 모양이 원(CIRCLE) 일 때만 쓰인다.
    double radius;

    //원용 생성자
    Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }


    //사갹형용 생성자
    Figure(double length, double width) {
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI * (radius * radius);
            case RECTANGLE:
                return length * width;
            default:
                throw new AssertionError(shape);
        }
    }
}
