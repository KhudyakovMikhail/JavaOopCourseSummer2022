package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(-9.7, 14.9);

        double range1Length = range.getLength();

        System.out.println("������ ���������: " + range.getFrom() + ", ����� ���������: " + range.getTo());
        System.out.println("����� ��������� ����������: " + range1Length);

        while (true) {
            System.out.println("������� �����:");

            double number = scanner.nextDouble();

            if (range.isInside(number)) {
                System.out.println("��������� ����� ����� ������ ���������");
                break;
            }

            System.out.println("��������� ����� ����� ��� ���������");
        }

        System.out.println();

        System.out.println("������� ����� ������ ���������:");
        range.setFrom(scanner.nextDouble());

        System.out.println("������� ����� ����� ���������");
        range.setTo(scanner.nextDouble());

        System.out.println("������ ������ ���������: " + range.getFrom() + ", ����� ���������: " + range.getTo());
        System.out.println("����� ��������� ����������: " + range.getLength());
    }
}
