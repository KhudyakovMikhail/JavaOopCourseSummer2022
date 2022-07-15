package ru.academits.khudyakov.range_main;

import ru.academits.khudyakov.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(-9.7, 14.9);

        double range1Length = range1.getLength();

        System.out.println("������ ���������: " + range1.getFrom() + ", ����� ���������: " + range1.getTo());
        System.out.println("����� ��������� ����������: " + range1Length);

        while (true) {
            System.out.println("������� �����:");

            double number = scanner.nextDouble();

            if (range1.isInside(number)) {
                System.out.println("��������� ����� ����� ������ ���������");
                break;
            }

            System.out.println("��������� ����� ����� ��� ���������");
        }

        System.out.println();

        System.out.println("������� ����� ������ ���������:");
        range1.setFrom(scanner.nextDouble());

        System.out.println("������� ����� ����� ���������");
        range1.setTo(scanner.nextDouble());

        System.out.println("������ ������ ���������: " + range1.getFrom() + ", ����� ���������: " + range1.getTo());
        System.out.println("����� ��������� ����������: " + range1.getLength());
    }
}
