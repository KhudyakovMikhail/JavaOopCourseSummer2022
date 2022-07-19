package ru.academits.khudyakov.range2_main;

import ru.academits.khudyakov.range.Range;

public class Range2_main {
    public static void main(String[] args) {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(6, 15);
        Range range3 = new Range(-10, 5);
        Range range4 = new Range(3, 7);
        Range range5 = new Range(-10, 15);

        System.out.println("Пересечение диапазонов 1 и 1: от " + range1.getIntersection(range1).getFrom() + " до " + range1.getIntersection(range1).getTo());
        System.out.println("Пересечение диапазонов 1 и 2: от " + range1.getIntersection(range2).getFrom() + " до " + range1.getIntersection(range2).getTo());
        System.out.println("Пересечение диапазонов 1 и 3: от " + range1.getIntersection(range3).getFrom() + " до " + range1.getIntersection(range3).getTo());
        System.out.println("Пересечение диапазонов 1 и 4: от " + range1.getIntersection(range4).getFrom() + " до " + range1.getIntersection(range4).getTo());
        System.out.println("Пересечение диапазонов 1 и 5: от " + range1.getIntersection(range5).getFrom() + " до " + range1.getIntersection(range5).getTo());
        System.out.println();

        System.out.println("Объединение диапазонов 1 и 1: от " + range1.getUnion(range1)[0].getFrom() + " до " + range1.getUnion(range1)[0].getTo());
        System.out.println("Объединение диапазонов 1 и 2: от " + range1.getUnion(range2)[0].getFrom() + " до " + range1.getUnion(range2)[0].getTo());
        System.out.println("Объединение диапазонов 1 и 3: от " + range1.getUnion(range3)[0].getFrom() + " до " + range1.getUnion(range3)[0].getTo());
        System.out.println("Объединение диапазонов 1 и 4: от " + range1.getUnion(range4)[0].getFrom() + " до " + range1.getUnion(range4)[0].getTo());
        System.out.println("Объединение диапазонов 1 и 5: от " + range1.getUnion(range5)[0].getFrom() + " до " + range1.getUnion(range5)[0].getTo());
        System.out.println("Объединение диапазонов 2 и 3: от " + range2.getUnion(range3)[0].getFrom() + " до " + range2.getUnion(range3)[0].getTo() +
                " и от " + range2.getUnion(range3)[1].getFrom() + " до " + range2.getUnion(range3)[1].getTo());
        System.out.println();

        System.out.println("Разность диапазонов 1 и 2: от " + range1.getDefinition(range2)[0].getFrom() + " до " + range1.getDefinition(range2)[0].getTo());
        System.out.println("Разность диапазонов 1 и 3: от " + range1.getDefinition(range3)[0].getFrom() + " до " + range1.getDefinition(range3)[0].getTo());
        System.out.println("Разность диапазонов 2 и 3: от " + range2.getDefinition(range3)[0].getFrom() + " до " + range2.getDefinition(range3)[0].getTo());
        System.out.println("Разность диапазонов 2 и 4: от " + range2.getDefinition(range4)[0].getFrom() + " до " + range2.getDefinition(range4)[0].getTo());
        System.out.println("Разность диапазонов 1 и 4: от " + range1.getDefinition(range4)[0].getFrom() + " до " + range1.getDefinition(range4)[0].getTo() +
                " и от " + range1.getDefinition(range4)[1].getFrom() + " до " + range1.getDefinition(range4)[1].getTo());
        System.out.println("Разность диапазонов 5 и 1: от " + range5.getDefinition(range1)[0].getFrom() + " до " + range5.getDefinition(range1)[0].getTo() +
                " и от " + range5.getDefinition(range1)[1].getFrom() + " до " + range5.getDefinition(range1)[1].getTo());
    }
}
