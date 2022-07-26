package ru.academits.khudyakov.shapes;

public class Triangle implements Shape {
    static final double EPSILON = 1.0e-10;

    private final double x1;
    private final double y1;

    private final double x2;
    private final double y2;

    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    // упростить getWidth, getHeight
    public double getWidth() {
        return Math.max(Math.max(x1, x2), Math.max(x2, x3)) - Math.min(Math.min(x1, x2), Math.min(x2, x3));
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), Math.max(y2, y3)) - Math.min(Math.min(y1, y2), Math.min(y2, y3));
    }

    public double getArea() {
        if (Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) <= EPSILON) {
            return 0;
        }

        double aBLength = getSideLength(x1,y1,x2,y2);
        double bCLength = getSideLength(x2,y2,x3,y3);
        double aCLength = getSideLength(x1,y1,x3,y3);

        double halfPerimeter = (aBLength + bCLength + aCLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - aBLength) * (halfPerimeter - bCLength) * (halfPerimeter - aCLength));
    }

    public double getPerimeter() {
        double aBLength = getSideLength(x1,y1,x2,y2);
        double bCLength = getSideLength(x2,y2,x3,y3);
        double aCLength = getSideLength(x1,y1,x3,y3);

        return aBLength + bCLength + aCLength;
    }

    private static double getSideLength(double x1, double y1, double x2,  double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return String.format("Вершины треугольника: (%f, %f), (%f, %f), (%f, %f)", x1, y1, x2, y2, x3, y3) +
                " Ширина треугольника = " + getWidth() + " Высота треугольника = " + getHeight() +
                " Площадь треугольника = " + String.format("%.3f", getArea()) + " Периметр треугольника = " + String.format("%.3f", getPerimeter());
    }
}
