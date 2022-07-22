package ru.academits.khudyakov.shapes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
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
        final int SQUARE_SIDES_COUNT = 4;
        return SQUARE_SIDES_COUNT * sideLength;
    }
}
