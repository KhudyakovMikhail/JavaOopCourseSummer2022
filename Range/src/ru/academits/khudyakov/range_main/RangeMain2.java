package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

public class RangeMain2 {
    public static String printRangeArray(Range[] ranges) {
        int iMax = ranges.length - 1;

        if (iMax == -1) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; ; i++) {
            stringBuilder.append(ranges[i]);

            if (i == iMax) {
                return stringBuilder.append(']').toString();
            }

            stringBuilder.append(", ");
        }
    }

    public static void main(String[] args) {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(6, 15);
        Range range3 = new Range(-10, 5);
        Range range4 = new Range(3, 7);
        Range range5 = new Range(-10, 15);

        System.out.println("Пересечение диапазонов 1 и 1: " + range1.getIntersection(range1));
        System.out.println("Пересечение диапазонов 1 и 2: " + range1.getIntersection(range2));
        System.out.println("Пересечение диапазонов 1 и 3: " + range1.getIntersection(range3));
        System.out.println("Пересечение диапазонов 1 и 4: " + range1.getIntersection(range4));
        System.out.println("Пересечение диапазонов 1 и 5: " + range1.getIntersection(range5));
        System.out.println("Пересечение диапазонов 2 и 3: " + range2.getIntersection(range3));
        System.out.println();

        System.out.println("Объединение диапазонов 1 и 1: " + printRangeArray(range1.getUnion(range1)));
        System.out.println("Объединение диапазонов 1 и 2: " + printRangeArray(range1.getUnion(range2)));
        System.out.println("Объединение диапазонов 1 и 3: " + printRangeArray(range1.getUnion(range3)));
        System.out.println("Объединение диапазонов 1 и 4: " + printRangeArray(range1.getUnion(range4)));
        System.out.println("Объединение диапазонов 1 и 5: " + printRangeArray(range1.getUnion(range5)));
        System.out.println("Объединение диапазонов 2 и 3: " + printRangeArray(range2.getUnion(range3)));
        System.out.println();

        System.out.println("Разность диапазонов 1 и 1: " + printRangeArray(range1.getDifference(range1)));
        System.out.println("Разность диапазонов 1 и 2: " + printRangeArray(range1.getDifference(range2)));
        System.out.println("Разность диапазонов 1 и 3: " + printRangeArray(range1.getDifference(range3)));
        System.out.println("Разность диапазонов 1 и 5: " + printRangeArray(range1.getDifference(range5)));
        System.out.println("Разность диапазонов 2 и 3: " + printRangeArray(range2.getDifference(range3)));
        System.out.println("Разность диапазонов 2 и 4: " + printRangeArray(range2.getDifference(range4)));
        System.out.println("Разность диапазонов 1 и 4: " + printRangeArray(range1.getDifference(range4)));
    }
}
