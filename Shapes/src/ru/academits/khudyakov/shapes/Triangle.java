package ru.academits.khudyakov.shapes;

public class Triangle implements Shape{

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

    public double getWidth() {
        return Math.max(Math.max(x1, x2), Math.max(x2, x3)) - Math.min(Math.min(x1, x2), Math.min(x2, x3));
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), Math.max(y2, y3)) - Math.min(Math.min(y1, y2), Math.min(y2, y3));
    }

    public double getArea() {
        final double EPSILON = 1.0e-10;

        if (Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) <= EPSILON) {
            return 0;
        }

        double lengthAB = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double lengthBC = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double lengthAC = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));

        double halfPerimeter = (lengthAB + lengthBC + lengthAC) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - lengthAB) * (halfPerimeter - lengthBC) * (halfPerimeter - lengthAC));
    }

    public double getPerimeter() {
        double lengthAB = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double lengthBC = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double lengthAC = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));

        return lengthAB + lengthBC + lengthAC;
    }
}
