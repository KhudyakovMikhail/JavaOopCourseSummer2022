package ru.academits.khudyakov.matrix_main;

import ru.academits.khudyakov.matrix.Matrix;
import ru.academits.khudyakov.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 4);

        System.out.println("���������� ����� ������� 1" + matrix1.getRowsCount());
        System.out.println("���������� �������� ������� 1" + matrix1.getColumnsCount());

        matrix1.setRow(0, new Vector(new double[]{1, 2, 3, 4}));
        matrix1.setRow(1, new Vector(new double[]{2, 3, 4, 5}));
        System.out.println("������� 1 " + matrix1);

        System.out.println("������� ������� �� ������� 1 " + matrix1.getColumn(1));

        matrix1.multiplyByScalar(2);
        System.out.println("�������� ������� 1 �� 2 " + matrix1);

        matrix1.transpose();
        System.out.println("��������������� ������� 1 " + matrix1);
        System.out.println();

        Matrix matrix2 = new Matrix(4, 2);

        matrix2.setRow(0, new Vector(new double[]{3, 4}));
        matrix2.setRow(1, new Vector(new double[]{2, 5}));
        matrix2.setRow(2, new Vector(new double[]{1, 3}));
        matrix2.setRow(3, new Vector(new double[]{4, 7}));

        System.out.println("������� 1 " + matrix1);
        System.out.println("������� 2 " + matrix2);
        System.out.println();
        matrix1.add(matrix2);
        System.out.println("������� ������� 1 � �������� 2 " + matrix1);
        matrix1.subtract(matrix2);
        System.out.println("����� �� ������� 1 ������� 2 " + matrix1);
        System.out.println();

        System.out.println("������� ������� 1 � �������� 2 " + Matrix.getSum(matrix1, matrix2));
        System.out.println("����� �� ������� 1 ������� 2 " + Matrix.getDifference(matrix1, matrix2));
        System.out.println();

        System.out.println("������� ������� 3 ������������� �����������");
        Matrix matrix3 = new Matrix(matrix1);

        System.out.println("������� 3" + matrix3);
        System.out.println();

        System.out.println("������� ������� 4 �� ���������� �������");
        Matrix matrix4 = new Matrix(new double[][]{
                {},
                {},
                {3, 4, 5, 6}
        });

        System.out.println(matrix4);
        System.out.println();

        System.out.println("������� ������� 5 �� ������� ��������");
        Matrix matrix5 = new Matrix(new Vector[]{
                new Vector(new double[]{1, 2, 3}),
                new Vector(new double[]{2, 3, 4, 5, 6}),
                new Vector(new double[]{3, 4}),
                new Vector(new double[]{4, 5, 6}),
        });

        System.out.println("������� ������ ������� 5 � �������:");

        for (int i = 0; i < matrix5.getRowsCount(); i++) {
            System.out.println(matrix5.getRow(i));
        }

        System.out.println();

        Matrix matrix6 = new Matrix(new double[][]{
                {1, 3, 3, 0, 0},
                {2, 3, 4, 0, 0},
                {11, 12, 13, 4, 15},
                {0, 4, 4, 0, 16},
                {0, 17, 0, 17, 0}
        });

        System.out.println("������������ ������� 6 �����: " + matrix6.getDeterminant());
        System.out.println();

        Matrix matrix7 = new Matrix(new double[][]{
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1},
                {2, 4, 0}
        });

        Vector vector1 = new Vector(new double[]{1, 2, -1});
        System.out.println("�������� ������� 7 �� ������ " + matrix7.multiplyByVector(vector1));
        System.out.println();

        Matrix matrix8 = new Matrix(new double[][]{
                {1, 2},
                {2, -3},
                {2, -1}
        });

        Matrix matrix9 = Matrix.getProduct(matrix7, matrix8);
        System.out.println("�������� ������� 7 �� ������� 8 " + matrix9);
    }
}
