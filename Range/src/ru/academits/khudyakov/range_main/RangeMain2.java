package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

public class RangeMain2 {
    public static String printRangesArray(Range[] ranges) {
        if (ranges.length == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (Range range : ranges) {
            stringBuilder.append(range).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(6, 15);
        Range range3 = new Range(-10, 5);
        Range range4 = new Range(3, 7);
        Range range5 = new Range(-10, 15);

        System.out.println("����������� ���������� 1 � 1: " + range1.getIntersection(range1));
        System.out.println("����������� ���������� 1 � 2: " + range1.getIntersection(range2));
        System.out.println("����������� ���������� 1 � 3: " + range1.getIntersection(range3));
        System.out.println("����������� ���������� 1 � 4: " + range1.getIntersection(range4));
        System.out.println("����������� ���������� 1 � 5: " + range1.getIntersection(range5));
        System.out.println("����������� ���������� 2 � 3: " + range2.getIntersection(range3));
        System.out.println();

        System.out.println("����������� ���������� 1 � 1: " + printRangesArray(range1.getUnion(range1)));
        System.out.println("����������� ���������� 1 � 2: " + printRangesArray(range1.getUnion(range2)));
        System.out.println("����������� ���������� 1 � 3: " + printRangesArray(range1.getUnion(range3)));
        System.out.println("����������� ���������� 1 � 4: " + printRangesArray(range1.getUnion(range4)));
        System.out.println("����������� ���������� 1 � 5: " + printRangesArray(range1.getUnion(range5)));
        System.out.println("����������� ���������� 2 � 3: " + printRangesArray(range2.getUnion(range3)));
        System.out.println();

        System.out.println("�������� ���������� 1 � 1: " + printRangesArray(range1.getDifference(range1)));
        System.out.println("�������� ���������� 1 � 2: " + printRangesArray(range1.getDifference(range2)));
        System.out.println("�������� ���������� 1 � 3: " + printRangesArray(range1.getDifference(range3)));
        System.out.println("�������� ���������� 1 � 5: " + printRangesArray(range1.getDifference(range5)));
        System.out.println("�������� ���������� 2 � 3: " + printRangesArray(range2.getDifference(range3)));
        System.out.println("�������� ���������� 2 � 4: " + printRangesArray(range2.getDifference(range4)));
        System.out.println("�������� ���������� 1 � 4: " + printRangesArray(range1.getDifference(range4)));
    }
}
