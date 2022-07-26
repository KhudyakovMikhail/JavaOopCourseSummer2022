package ru.academits.khudyakov.shapes_main;

import ru.academits.khudyakov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapes = {new Square(4), new Rectangle(2, 8), new Circle(2.4), new Triangle(0, 1, 2, 1, 4, 2), new Rectangle(3, 5),
                new Triangle(-1, -1, 2, -4, 3, 4), new Square(3), new Circle(2), new Triangle(-1, 1, 2, 1, 4, 1)};

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println();

        System.out.println("Фигура с максимальной площадью: " + getMaxAreaShape(shapes));
        System.out.println("Фигура со вторым периметром: " + getSecondPerimeterShape(shapes));
    }

    public static Shape getMaxAreaShape(Shape[] shapes) {
        Comparator<Shape> areaComparator = new AreaComparator();

        Arrays.sort(shapes, areaComparator);

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Comparator<Shape> perimeterComparator = new PerimeterComparator();

        Arrays.sort(shapes, perimeterComparator);

        return shapes[shapes.length - 2];
    }
}
