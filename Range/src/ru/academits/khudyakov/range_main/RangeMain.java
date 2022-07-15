package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(-9.7, 14.9);

        double range1Length = range1.getLength();

        System.out.println("Начало диапазона: " + range1.getFrom() + ", Конец диапазона: " + range1.getTo());
        System.out.println("Длина диапазона составляет: " + range1Length);

        while (true) {
            System.out.println("Введите число:");

            double number = scanner.nextDouble();

            if (range1.isInside(number)) {
                System.out.println("Введенное число лежит внутри диапазона");
                break;
            }

            System.out.println("Введенное число лежит вне диапазона");
        }

        System.out.println();

        System.out.println("Введите новое начало диапазона:");
        range1.setFrom(scanner.nextDouble());

        System.out.println("Введите новый конец диапазона");
        range1.setTo(scanner.nextDouble());

        System.out.println("Теперь начало диапазона: " + range1.getFrom() + ", Конец диапазона: " + range1.getTo());
        System.out.println("Длина диапазона составляет: " + range1.getLength());
    }
}
