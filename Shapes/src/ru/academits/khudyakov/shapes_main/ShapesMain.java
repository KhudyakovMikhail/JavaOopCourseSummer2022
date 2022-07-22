package ru.academits.khudyakov.shapes_main;

import ru.academits.khudyakov.shapes.*;

public class ShapesMain {
    public static void main(String[] args) {
        Shape square = new Square(2);
        System.out.printf("Ширина квадрата = %.2f, Высота квадрата = %.2f, Площадь квадрата = %.2f, Периметр квадрата = %.2f",
                square.getWidth(), square.getHeight(), square.getArea(), square.getPerimeter());
        System.out.println();

        Shape rectangle = new Rectangle(4, 3);
        System.out.printf("Ширина прямоугольника = %.2f, Высота прямоугольника = %.2f, Площадь прямоугольника = %.2f, Периметр прямоугольника = %.2f",
                rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea(), rectangle.getPerimeter());
        System.out.println();

        Shape circle = new Circle(3);
        System.out.printf("Ширина круга = %.2f, Высота круга = %.2f, Площадь круга = %.2f, Периметр круга = %.2f",
                circle.getWidth(), circle.getHeight(), circle.getArea(), circle.getPerimeter());
        System.out.println();

        Shape triangle1 = new Triangle(-1, -1, 3, 2, 3, -1);
        System.out.printf("Ширина первого треугольника = %.2f, Высота первого треугольника = %.2f, Площадь первого треугольника = %.2f, Периметр первого треугольника = %.2f",
                triangle1.getWidth(), triangle1.getHeight(), triangle1.getArea(), triangle1.getPerimeter());
        System.out.println();

        Shape triangle2 = new Triangle(-3, 2, 1, 2, 4, 2);
        System.out.printf("Ширина второго треугольника = %.2f, Высота второго треугольника = %.2f, Площадь второго треугольника = %.2f, Периметр второго треугольника = %.2f",
                triangle2.getWidth(), triangle2.getHeight(), triangle2.getArea(), triangle2.getPerimeter());
    }
}
