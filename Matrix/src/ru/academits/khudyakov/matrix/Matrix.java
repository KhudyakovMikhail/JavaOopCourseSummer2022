package ru.academits.khudyakov.matrix;

import ru.academits.khudyakov.matrix_comparators.ArraysLengthComparator;
import ru.academits.khudyakov.matrix_comparators.VectorsLengthComparator;
import ru.academits.khudyakov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Количество строк и столбцов матрицы не может быть < 1; Количество строк: " +
                    rowsCount + "; Количество столбцов: " + columnsCount);
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.getRowsCount()];

        for (int i = 0; i < matrix.getRowsCount(); i++) {
            rows[i] = matrix.getRow(i);
        }
    }

    public Matrix(double[][] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Длина массива должна быть > 0");
        }

        boolean isEmpty = true;

        for (double[] components : array) {
            if (components.length > 0) {
                isEmpty = false;
                break;
            }
        }

        if (isEmpty) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        rows = new Vector[array.length];

        int matrixColumnsCount = getMatrixColumnsCount(array);

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(matrixColumnsCount, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length <= 0) {
            throw new IllegalArgumentException("Длина массива векторов должна быть 0; Длина массива: " + vectors.length);
        }
        rows = new Vector[vectors.length];

        int matrixColumnsCount = getMatrixColumnsCount(vectors);

        for (int i = 0; i < vectors.length; i++) {
            double[] vectorComponents = new double[matrixColumnsCount];

            for (int j = 0; j < vectors[i].getSize(); j++) {
                vectorComponents[j] = vectors[i].getComponent(j);
            }

            rows[i] = new Vector(matrixColumnsCount, vectorComponents);
        }
    }

    private static int getMatrixColumnsCount(Vector[] vectors) {
        Vector[] sortedArray;

        sortedArray = Arrays.copyOf(vectors, vectors.length);

        Arrays.sort(sortedArray, new VectorsLengthComparator());

        return sortedArray[vectors.length - 1].getSize();
    }

    private static int getMatrixColumnsCount(double[][] array) {
        double[][] sortedArray = new double[array.length][];

        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = Arrays.copyOf(array[i], array[i].length);
        }

        Arrays.sort(sortedArray, new ArraysLengthComparator());

        return sortedArray[array.length - 1].length;
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        //Здесь нужно исключение
        return rows[index];
    }

    public void setRow(int index, Vector row) {
        //Здесь нужно исключение
        rows[index] = row;
    }

    public double[] getColumn(int index) {
        //Здесь нужно исключение
        double[] column = new double[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            column[i] = rows[i].getComponent(index);
        }

        return column;
    }

    public void transpose() {
        int transposedLength = getColumnsCount();

        Vector[] transposedRows = new Vector[transposedLength];

        for (int i = 0; i < transposedLength; i++) {
            transposedRows[i] = new Vector(getColumn(i));
        }

        rows = transposedRows;
    }

    public void multiplyOnScalar(double scalar) {
        for (Vector row : rows) {
            row.multiplyOnScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (rows.length != rows[0].getSize()) {
            throw new IllegalArgumentException("Для вычисления определителя матрица должна быть квадратной; Количество строк: " +
                    getRowsCount() + "; Количество столбцов: " + getColumnsCount());
        }

        if (rows.length == 1) {
            return rows[0].getComponent(0);
        }

        double determinant = 0;
        int matrixOrder = rows.length;

        for (int i = 0; i < matrixOrder; i++) {
            Matrix additionalMinor = new Matrix(new double[matrixOrder - 1][matrixOrder - 1]);

            for (int j = 0; j < matrixOrder - 1; j++) {
                for (int k = 0; k < matrixOrder - 1; k++) {
                    if (k < i) {
                        additionalMinor.rows[j].setComponent(k, rows[j + 1].getComponent(k));
                    } else {
                        additionalMinor.rows[j].setComponent(k, rows[j + 1].getComponent(k + 1));
                    }
                }
            }

            determinant += Math.pow(-1, i) * rows[0].getComponent(i) * additionalMinor.getDeterminant();
        }

        return determinant;
    }

    public void add(Matrix matrix) {
        //exception
        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].add(matrix.getRow(i));
        }
    }

    public void subtract(Matrix matrix) {
        //exception
        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].subtract(matrix.getRow(i));
        }
    }

    public void multiplyOnVector(Vector vector) {
        //exception

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (Vector vector : rows) {
            stringBuilder.append(vector).append(", ");
        }

        stringBuilder.delete((stringBuilder.length() - 2), stringBuilder.length());
        stringBuilder.append('}');

        return stringBuilder.toString();
    }
}
