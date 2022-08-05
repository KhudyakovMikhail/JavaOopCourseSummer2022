package ru.academits.khudyakov.comparator;

import ru.academits.khudyakov.vector.Vector;

import java.util.Comparator;

public class VectorsLengthComparator implements Comparator<Vector> {
    @Override
    public int compare(Vector vector1, Vector vector2) {
        return vector1.getSize() - vector2.getSize();
    }
}
