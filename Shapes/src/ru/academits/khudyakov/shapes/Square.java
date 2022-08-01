package ru.academits.khudyakov.shapes;

public class Square implements Shape {
    private final double sideLength;
    private static final int SIDES_COUNT = 4;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return SIDES_COUNT * sideLength;
    }

    @Override
    public String toString() {
        return String.format("Фигура - квадрат Сторона = %f Площадь = %.3f Периметр = %.3f", sideLength, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) object;

        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }
}
