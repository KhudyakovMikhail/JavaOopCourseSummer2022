package ru.academits.khudyakov.shapes;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    final static double EPSILON = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getPerimeter() - shape2.getPerimeter() > EPSILON) {
            return 1;
        }

        if (Math.abs(shape1.getPerimeter() - shape2.getPerimeter()) <= EPSILON) {
            return 0;
        }

        return -1;
    }
}
