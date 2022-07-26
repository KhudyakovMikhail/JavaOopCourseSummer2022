package ru.academits.khudyakov.shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    final static double EPSILON = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getArea() - shape2.getArea() > EPSILON) {
            return 1;
        }

        if (Math.abs(shape1.getArea() - shape2.getArea()) <= EPSILON) {
            return 0;
        }

        return -1;
    }
}
