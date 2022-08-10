package ru.academits.khudyakov.vector_main;

import ru.academits.khudyakov.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2);

        Vector vector2 = new Vector(vector1);

        Vector vector3 = new Vector(new double[]{2, 3, -5});

        Vector vector4 = new Vector(4, new double[]{0, -4, 2, 6});

        Vector vector5 = new Vector(6, new double[]{-3, 2, 7, 6});

        Vector vector6 = new Vector(vector5);

        System.out.println("����������� ������� 6: " + vector6.getSize());

        vector2.setComponent(0, -3);
        vector2.setComponent(1, 2);
        System.out.println("���������� ������� 2: {" + vector2.getComponent(0) + ", " + vector2.getComponent(1) + "}");
        System.out.println("������ ������� 2: " + vector2.getLength());

        vector3.add(vector4);
        System.out.println("��������� � ������� 3 ������ 4: " + vector3);

        System.out.println("���������� ������� 4 � 3: " + Vector.getSum(vector4, vector3));

        vector4.subtract(vector5);
        System.out.println("����� �� ������� 4 ������ 5: " + vector4);

        System.out.println("�������� �� ������� 4 ������ 5: " + Vector.getDifference(vector4, vector5));

        vector5.subtract(vector4);
        System.out.println("����� �� ������� 5 ������ 4: " + vector5);

        vector4.multiplyByScalar(0.5);
        System.out.println("�������� ������ 4 �� 0.5: " + vector4);

        vector6.revert();
        System.out.println("�������� ������ 6: " + vector6);

        System.out.println("��������� ������������ �������� 2 � 5: " + Vector.getScalarProduct(vector2, vector5));
    }
}
