package ru.academits.khudyakov.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Ширина прямоугольника = " + width + " Высота прямоугольника = " + height +
                " Площадь прямоугольника = " + String.format("%.3f", getArea()) + " Периметр прямоугольника = " + String.format("%.3f", getPerimeter());
    }
}
