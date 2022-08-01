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

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        if (Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) <= EPSILON) {
            return 0;
        }

        double abLength = getSideLength(x1, y1, x2, y2);
        double bcLength = getSideLength(x2, y2, x3, y3);
        double acLength = getSideLength(x1, y1, x3, y3);

        double halfPerimeter = (abLength + bcLength + acLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - abLength) * (halfPerimeter - bcLength) * (halfPerimeter - acLength));
    }

    @Override
    public double getPerimeter() {
        double abLength = getSideLength(x1, y1, x2, y2);
        double bcLength = getSideLength(x2, y2, x3, y3);
        double acLength = getSideLength(x1, y1, x3, y3);

        return abLength + bcLength + acLength;
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return String.format("Фигура - треугольник Вершины треугольника: (%f; %f), (%f; %f), (%f; %f) Площадь = %.3f Периметр = %.3f",
                x1, y1, x2, y2, x3, y3, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) object;

        return (x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 && y2 == triangle.y2 && x3 == triangle.x3 && y3 == triangle.y3);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }
}
