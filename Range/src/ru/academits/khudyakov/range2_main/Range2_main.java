package ru.academits.khudyakov.range2_main;

import ru.academits.khudyakov.range.Range;

public class Range2_main {
    public static void main(String[] args) {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(6, 15);
        Range range3 = new Range(-10, 5);
        Range range4 = new Range(3, 7);
        Range range5 = new Range(-10, 15);

        System.out.println("����������� ���������� 1 � 1: �� " + range1.getIntersection(range1).getFrom() + " �� " + range1.getIntersection(range1).getTo());
        System.out.println("����������� ���������� 1 � 2: �� " + range1.getIntersection(range2).getFrom() + " �� " + range1.getIntersection(range2).getTo());
        System.out.println("����������� ���������� 1 � 3: �� " + range1.getIntersection(range3).getFrom() + " �� " + range1.getIntersection(range3).getTo());
        System.out.println("����������� ���������� 1 � 4: �� " + range1.getIntersection(range4).getFrom() + " �� " + range1.getIntersection(range4).getTo());
        System.out.println("����������� ���������� 1 � 5: �� " + range1.getIntersection(range5).getFrom() + " �� " + range1.getIntersection(range5).getTo());
        System.out.println();

        System.out.println("����������� ���������� 1 � 1: �� " + range1.getUnion(range1)[0].getFrom() + " �� " + range1.getUnion(range1)[0].getTo());
        System.out.println("����������� ���������� 1 � 2: �� " + range1.getUnion(range2)[0].getFrom() + " �� " + range1.getUnion(range2)[0].getTo());
        System.out.println("����������� ���������� 1 � 3: �� " + range1.getUnion(range3)[0].getFrom() + " �� " + range1.getUnion(range3)[0].getTo());
        System.out.println("����������� ���������� 1 � 4: �� " + range1.getUnion(range4)[0].getFrom() + " �� " + range1.getUnion(range4)[0].getTo());
        System.out.println("����������� ���������� 1 � 5: �� " + range1.getUnion(range5)[0].getFrom() + " �� " + range1.getUnion(range5)[0].getTo());
        System.out.println("����������� ���������� 2 � 3: �� " + range2.getUnion(range3)[0].getFrom() + " �� " + range2.getUnion(range3)[0].getTo() +
                " � �� " + range2.getUnion(range3)[1].getFrom() + " �� " + range2.getUnion(range3)[1].getTo());
        System.out.println();

        System.out.println("�������� ���������� 1 � 2: �� " + range1.getDefinition(range2)[0].getFrom() + " �� " + range1.getDefinition(range2)[0].getTo());
        System.out.println("�������� ���������� 1 � 3: �� " + range1.getDefinition(range3)[0].getFrom() + " �� " + range1.getDefinition(range3)[0].getTo());
        System.out.println("�������� ���������� 2 � 3: �� " + range2.getDefinition(range3)[0].getFrom() + " �� " + range2.getDefinition(range3)[0].getTo());
        System.out.println("�������� ���������� 2 � 4: �� " + range2.getDefinition(range4)[0].getFrom() + " �� " + range2.getDefinition(range4)[0].getTo());
        System.out.println("�������� ���������� 1 � 4: �� " + range1.getDefinition(range4)[0].getFrom() + " �� " + range1.getDefinition(range4)[0].getTo() +
                " � �� " + range1.getDefinition(range4)[1].getFrom() + " �� " + range1.getDefinition(range4)[1].getTo());
        System.out.println("�������� ���������� 5 � 1: �� " + range5.getDefinition(range1)[0].getFrom() + " �� " + range5.getDefinition(range1)[0].getTo() +
                " � �� " + range5.getDefinition(range1)[1].getFrom() + " �� " + range5.getDefinition(range1)[1].getTo());
    }
}
