package ru.academits.khudyakov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора \"" + size + "\" должна быть > 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размерность вектора \"" + components.length + "\" должна быть > 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора \"" + size + "\" должна быть > 0");
        }

        this.components = Arrays.copyOf(components, size);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Значение \"" + index + "\" выходит за границы массива. Значение индекса должно быть >= 0 и < " + components.length);
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Значение \"" + index + "\" выходит за границы массива. Значение индекса должно быть >= 0 и < " + components.length);
        }

        components[index] = value;
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public void add(Vector vector) {
        int lesserSize = Math.min(components.length, vector.components.length);
        int greaterSize = Math.max(components.length, vector.components.length);

        Vector greaterVector = (components.length >= vector.components.length) ? this : vector;

        if (vector.components.length > components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < greaterSize; i++) {
            if (i < lesserSize) {
                components[i] += vector.components[i];
            } else {
                components[i] = greaterVector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        int lesserSize = Math.min(components.length, vector.components.length);
        int greaterSize = Math.max(components.length, vector.components.length);

        if (vector.components.length > components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < greaterSize; i++) {
            if (i < lesserSize) {
                components[i] -= vector.components[i];
            } else {
                if (vector.components.length > components.length) {
                    components[i] = - vector.components[i];
                }
            }
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void revert() {
        multiplyByScalar(-1);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.add(vector2);

        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.subtract(vector2);

        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minimumSize = Math.min(vector1.components.length, vector2.components.length);

        double scalarProduct = 0;

        for (int i = 0; i < minimumSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (double component : components) {
            stringBuilder.append(component).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        return Arrays.equals(components, ((Vector) object).components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }
}
