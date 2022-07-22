package ru.academits.khudyakov.shapes_main;

import ru.academits.khudyakov.shapes.*;

public class ShapesMain {
    public static void main(String[] args) {
        Shape square = new Square(2);
        System.out.printf("������ �������� = %.2f, ������ �������� = %.2f, ������� �������� = %.2f, �������� �������� = %.2f",
                square.getWidth(), square.getHeight(), square.getArea(), square.getPerimeter());
        System.out.println();

        Shape rectangle = new Rectangle(4, 3);
        System.out.printf("������ �������������� = %.2f, ������ �������������� = %.2f, ������� �������������� = %.2f, �������� �������������� = %.2f",
                rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea(), rectangle.getPerimeter());
        System.out.println();

        Shape circle = new Circle(3);
        System.out.printf("������ ����� = %.2f, ������ ����� = %.2f, ������� ����� = %.2f, �������� ����� = %.2f",
                circle.getWidth(), circle.getHeight(), circle.getArea(), circle.getPerimeter());
        System.out.println();

        Shape triangle1 = new Triangle(-1, -1, 3, 2, 3, -1);
        System.out.printf("������ ������� ������������ = %.2f, ������ ������� ������������ = %.2f, ������� ������� ������������ = %.2f, �������� ������� ������������ = %.2f",
                triangle1.getWidth(), triangle1.getHeight(), triangle1.getArea(), triangle1.getPerimeter());
        System.out.println();

        Shape triangle2 = new Triangle(-3, 2, 1, 2, 4, 2);
        System.out.printf("������ ������� ������������ = %.2f, ������ ������� ������������ = %.2f, ������� ������� ������������ = %.2f, �������� ������� ������������ = %.2f",
                triangle2.getWidth(), triangle2.getHeight(), triangle2.getArea(), triangle2.getPerimeter());
    }
}
