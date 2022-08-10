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
            rows[i] = new Vector(matrix.getRow(i));
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
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
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Длина массива векторов должна быть > 0; Длина массива: " + vectors.length);
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
        if (index < 0 || index >= getRowsCount()) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getRowsCount());
        }

        return rows[index];
    }

    public void setRow(int index, Vector row) {
        if (index < 0 || index >= getRowsCount()) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getRowsCount());
        }

        rows[index] = row;
    }

    public double[] getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getColumnsCount());
        }

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
            row.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (rows.length != getColumnsCount()) {
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

    public Vector multiplyOnVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Для умножения матрицы на вектор количество столбцов матрицы должно быть равно размерности вектора; количество столбцов матрицы: " +
                    getColumnsCount() + "; размерность вектора: " + vector.getSize());
        }
        double[] components = new double[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            components[i] = Vector.getScalarProduct(rows[i], vector);
        }

        return new Vector(components);
    }

    public void add(Matrix matrix) {
        if (matrix.getRowsCount() != getRowsCount() || matrix.getColumnsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("Складывать можно только матрицы одинаковых размерностей; размер исходной матрицы: " +
                    getRowsCount() + "x" + getColumnsCount() + "; размер матрицы - слагаемого: " + matrix.getRowsCount() + "x" + matrix.getColumnsCount());
        }

        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].add(matrix.getRow(i));
        }
    }

    public void subtract(Matrix matrix) {
        if (matrix.getRowsCount() != getRowsCount() || matrix.getColumnsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("Вычитать можно только матрицы одинаковых размерностей; размер исходной матрицы: " +
                    getRowsCount() + "x" + getColumnsCount() + "; размер вычитаемой матрицы: " + matrix.getRowsCount() + "x" + matrix.getColumnsCount());
        }

        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].subtract(matrix.getRow(i));
        }
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

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Складывать можно только матрицы одинаковых размерностей; размер матрицы A: " +
                    matrix1.getRowsCount() + "x" + matrix1.getColumnsCount() + "; размер матрицы B: " + matrix2.getRowsCount() + "x" + matrix2.getColumnsCount());
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.add(matrix2);

        return matrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитать можно только матрицы одинаковых размерностей; размер матрицы A: " +
                    matrix1.getRowsCount() + "x" + matrix1.getColumnsCount() + "; размер матрицы B: " + matrix2.getRowsCount() + "x" + matrix2.getColumnsCount());
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.subtract(matrix2);

        return matrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Умножение матриц возможно если число столбцов матрицы A = числу строк матрицы B; число столбцов матрицы A: " +
                    matrix1.getColumnsCount() + "; число строк матрицы B: " + matrix2.getRowsCount());
        }

        int resultRowsCount = matrix1.getRowsCount();
        int resultColumnsCount = matrix2.getColumnsCount();

        double[][] resultMatrix = new double[resultRowsCount][resultColumnsCount];

        for (int i = 0; i < resultRowsCount; i++) {
            for (int j = 0; j < resultColumnsCount; j++) {
                resultMatrix[i][j] = Vector.getScalarProduct(matrix1.getRow(i), new Vector(matrix2.getColumn(j)));
            }
        }

        return new Matrix(resultMatrix);
    }
}
