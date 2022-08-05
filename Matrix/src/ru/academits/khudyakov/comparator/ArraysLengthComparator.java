package ru.academits.khudyakov.comparator;

import java.util.Comparator;

public class ArraysLengthComparator implements Comparator<double[]>{
    @Override
    public int compare(double[] array1, double[] array2) {
        return array1.length - array2.length;
    }
}
