package ru.academits.khudyakov.matrix_main;

import ru.academits.khudyakov.matrix.Matrix;
import ru.academits.khudyakov.vector.Vector;

import java.util.Arrays;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 4);

        System.out.println("Количество строк матрицы 1" + matrix1.getRowsCount());
        System.out.println("Количество столбцов матрицы 1" + matrix1.getColumnsCount());

        matrix1.setRow(0, new Vector(new double[]{1, 2, 3, 4}));
        matrix1.setRow(1, new Vector(new double[]{2, 3, 4, 5}));
        System.out.println("Матрица 1 " + matrix1);

        System.out.println("Достаем столбец по индексу 1 " + Arrays.toString(matrix1.getColumn(1)));

        matrix1.multiplyOnScalar(2);
        System.out.println("Умножаем матрицу 1 на 2 " + matrix1);

        matrix1.transpose();
        System.out.println("Транспонировали матрицу 1 " + matrix1);
        System.out.println();

        Matrix matrix2 = new Matrix(4, 2);

        matrix2.setRow(0, new Vector(new double[]{3, 4}));
        matrix2.setRow(1, new Vector(new double[]{2, 5}));
        matrix2.setRow(2, new Vector(new double[]{1, 3}));
        matrix2.setRow(3, new Vector(new double[]{4, 7}));

        System.out.println("Матрица 1 " + matrix1);
        System.out.println("Матрица 2 " + matrix2);
        System.out.println();
        matrix1.add(matrix2);
        System.out.println("Сложили матрицу 1 с матрицей 2 " + matrix1);
        matrix1.subtract(matrix2);
        System.out.println("Вычли из матрицы 1 матрицу 2 " + matrix1);
        System.out.println();

        System.out.println("Сложили матрицу 1 с матрицей 2 " + Matrix.getSum(matrix1, matrix2));
        System.out.println("Вычли из матрицы 1 матрицу 2 " + Matrix.getDifference(matrix1, matrix2));
        System.out.println();

        System.out.println("Создаем матрицу 3 конструктором копирования");
        Matrix matrix3 = new Matrix(matrix1);

        System.out.println("Матрица 3" + matrix3);
        System.out.println();

        System.out.println("Создаем матрицу 4 из двумерного массива");
        Matrix matrix4 = new Matrix(new double[][]{
                {},
                {},
                {3, 4, 5, 6}
        });

        System.out.println(matrix4);
        System.out.println();

        System.out.println("Создаем матрицу 5 из массива векторов");
        Matrix matrix5 = new Matrix(new Vector[]{
                new Vector(new double[]{1, 2, 3}),
                new Vector(new double[]{2, 3, 4, 5, 6}),
                new Vector(new double[]{3, 4}),
                new Vector(new double[]{4, 5, 6}),
        });

        System.out.println(matrix5);
        System.out.println();

        Matrix matrix6 = new Matrix(new double[][]{
                {1, 3, 3, 0, 0},
                {2, 3, 4, 0, 0},
                {11, 12, 13, 4, 15},
                {0, 4, 4, 0, 16},
                {0, 17, 0, 17, 0}
        });

        System.out.println("Определитель матрицы 6 равен: " + matrix6.getDeterminant());
        System.out.println();

        Matrix matrix7 = new Matrix(new double[][]{
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1},
                {2, 4, 0}
        });

        Vector vector1 = new Vector(new double[]{1, 2, -1});
        System.out.println("Умножаем матрицу 7 на вектор " + matrix7.multiplyOnVector(vector1));
        System.out.println();

        Matrix matrix8 = new Matrix(new double[][]{
                {1, 2},
                {2, -3},
                {2, -1}
        });

        Matrix matrix9 = Matrix.getProduct(matrix7, matrix8);
        System.out.println("Умножаем матрицу 7 на матрицу 8 " + matrix9);
    }
}
