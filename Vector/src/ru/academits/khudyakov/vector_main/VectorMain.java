package ru.academits.khudyakov.vector_main;

import ru.academits.khudyakov.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2);

        Vector vector2 = new Vector(vector1);

        double[] vector3Components = {2, 3, -5};
        Vector vector3 = new Vector(vector3Components);

        double[] vector4Components = {0, -4, 2, 6};
        Vector vector4 = new Vector(4, vector4Components);

        double[] vector5Components = {-3, 2, 7, 6};
        Vector vector5 = new Vector(6, vector5Components);

        Vector vector6 = new Vector(vector5);

        System.out.println("Размерность вектора 6: " + vector6.getSize());

        vector2.setVectorComponent(0, -3);
        vector2.setVectorComponent(1, 2);
        System.out.println("Компоненты вектора 2: {" + vector2.getVectorComponent(0) + ", " + vector2.getVectorComponent(1) + "}");
        System.out.println("Длинна вектора 2: " + vector2.getVectorLength());

        System.out.println("Прибавляем к вектору 3 вектор 4: " + vector3.addVector(vector4));
        System.out.println("Складываем вектора 4 и 3:" + Vector.getVectorsSum(vector4, vector3));

        System.out.println("Вычитаем из вектора 4 вектор 5: " + vector4.subtractVector(vector5));
        System.out.println("Еще раз вычитаем из вектора 4 вектор 5: " + Vector.getVectorsDifference(vector4, vector5));
        System.out.println("А здесь вычитаем из вектора 5 вектор 4: " + vector5.subtractVector(vector4));

        vector4.scalarMultiply(0.5);
        System.out.println("Умножили вектор 4 на 0.5: " + vector4);

        vector6.revertVector();
        System.out.println("Обратили вектор 6: " + vector6);

        System.out.println("Скалярное произведение векторов 2 и 5: " + Vector.getVectorsScalarProduct(vector2, vector5));
    }
}
