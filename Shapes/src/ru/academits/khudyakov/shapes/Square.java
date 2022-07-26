package ru.academits.khudyakov.shapes;

public class Square implements Shape {
    private final double sideLength;
    static final int SQUARE_SIDES_COUNT = 4;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return SQUARE_SIDES_COUNT * sideLength;
    }

    @Override
    public String toString() {
        return "Сторона квадрата = " + sideLength + " Площадь квадрата = " + String.format("%.3f", getArea()) + " Периметр квадрата = " + String.format("%.3f", getPerimeter());
    }
}
