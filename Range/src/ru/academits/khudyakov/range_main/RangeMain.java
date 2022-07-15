package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(-9.7, 14.9);

        double range1Length = range.getLength();

        System.out.println("Начало диапазона: " + range.getFrom() + ", Конец диапазона: " + range.getTo());
        System.out.println("Длина диапазона составляет: " + range1Length);

        while (true) {
            System.out.println("Введите число:");

            double number = scanner.nextDouble();

            if (range.isInside(number)) {
                System.out.println("Введенное число лежит внутри диапазона");
                break;
            }

            System.out.println("Введенное число лежит вне диапазона");
        }

        System.out.println();

        System.out.println("Введите новое начало диапазона:");
        range.setFrom(scanner.nextDouble());

        System.out.println("Введите новый конец диапазона");
        range.setTo(scanner.nextDouble());

        System.out.println("Теперь начало диапазона: " + range.getFrom() + ", Конец диапазона: " + range.getTo());
        System.out.println("Длина диапазона составляет: " + range.getLength());
    }
}
