package ru.academits.khudyakov.shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "Радиус круга = " + radius + " Площадь круга = " + String.format("%.3f", getArea()) + " Периметр круга = " + String.format("%.3f", getPerimeter());
    }
}
