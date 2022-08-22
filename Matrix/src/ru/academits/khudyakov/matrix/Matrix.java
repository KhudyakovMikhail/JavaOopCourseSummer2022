package ru.academits.khudyakov.matrix;

import ru.academits.khudyakov.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Количество строк и столбцов матрицы не может быть < 1; Количество строк: "
                    + rowsCount + "; Количество столбцов: " + columnsCount);
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Длина массива должна быть > 0");
        }

        int matrixColumnsCount = getMatrixColumnsCount(array);

        if (matrixColumnsCount == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        rows = new Vector[array.length];

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
            rows[i] = new Vector(matrixColumnsCount);
            rows[i].add(vectors[i]);
        }
    }

    private static int getMatrixColumnsCount(Vector[] vectors) {
        int maxVectorsSize = vectors[0].getSize();

        for (int i = 1; i < vectors.length; i++) {
            if (vectors[i].getSize() > maxVectorsSize) {
                maxVectorsSize = vectors[i].getSize();
            }
        }

        return maxVectorsSize;
    }

    private static int getMatrixColumnsCount(double[][] array) {
        int maxSubArrayLength = array[0].length;

        for (int i = 1; i < array.length; i++) {
            if (array[i].length > maxSubArrayLength) {
                maxSubArrayLength = array[i].length;
            }
        }

        return maxSubArrayLength;
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= getRowsCount()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getRowsCount());
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector row) {
        if (index < 0 || index >= getRowsCount()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getRowsCount());
        }

        if (row.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размерность вектора должна быть равна количеству столбцов матрицы; размерность вектора = "
                    + row.getSize() + "; количество столбцов матрицы = " + getColumnsCount());
        }

        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " за пределами массива; индекс должен быть >= 0 и < " + getColumnsCount());
        }

        Vector column = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); i++) {
            column.setComponent(i, rows[i].getComponent(index));
        }

        return column;
    }

    public void transpose() {
        int transposedMatrixColumnsCount = getColumnsCount();

        Vector[] transposedRows = new Vector[transposedMatrixColumnsCount];

        for (int i = 0; i < transposedMatrixColumnsCount; i++) {
            transposedRows[i] = getColumn(i);
        }

        rows = transposedRows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector row : rows) {
            row.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (rows.length != getColumnsCount()) {
            throw new UnsupportedOperationException("Для вычисления определителя матрица должна быть квадратной; Количество строк: "
                    + getRowsCount() + "; Количество столбцов: " + getColumnsCount());
        }

        if (rows.length == 1) {
            return rows[0].getComponent(0);
        }

        double determinant = 0;
        int matrixOrder = rows.length;

        for (int i = 0; i < matrixOrder; i++) {
            Matrix additionalMinor = new Matrix(matrixOrder - 1, matrixOrder - 1);

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

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Для умножения матрицы на вектор количество столбцов матрицы должно быть равно размерности вектора; количество столбцов матрицы: "
                    + getColumnsCount() + "; размерность вектора: " + vector.getSize());
        }
        double[] components = new double[getRowsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            components[i] = Vector.getScalarProduct(rows[i], vector);
        }

        return new Vector(components);
    }

    private static void checkMatricesSizesEquality(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Операция не может быть выполнена, потому-что размеры матриц должны быть равны ; размер первой матрицы: "
                    + matrix1.getRowsCount() + "x" + matrix1.getColumnsCount() + "; размер второй матрицы: " + matrix2.getRowsCount() + "x" + matrix2.getColumnsCount());
        }
    }

    public void add(Matrix matrix) {
        checkMatricesSizesEquality(this, matrix);

        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        checkMatricesSizesEquality(this, matrix);

        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].subtract(matrix.rows[i]);
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
        checkMatricesSizesEquality(matrix1, matrix2);

        Matrix matrix = new Matrix(matrix1);
        matrix.add(matrix2);

        return matrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        checkMatricesSizesEquality(matrix1, matrix2);

        Matrix matrix = new Matrix(matrix1);
        matrix.subtract(matrix2);

        return matrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Умножение матриц возможно если число столбцов первой матрицы = числу строк второй матрицы; число столбцов первой матрицы: "
                    + matrix1.getColumnsCount() + "; число строк второй матрицы: " + matrix2.getRowsCount());
        }

        int resultRowsCount = matrix1.getRowsCount();
        int resultColumnsCount = matrix2.getColumnsCount();

        double[][] resultValues = new double[resultRowsCount][resultColumnsCount];

        for (int i = 0; i < resultRowsCount; i++) {
            for (int j = 0; j < resultColumnsCount; j++) {
                resultValues[i][j] = Vector.getScalarProduct(matrix1.rows[i], matrix2.getColumn(j));
            }
        }

        return new Matrix(resultValues);
    }
}
