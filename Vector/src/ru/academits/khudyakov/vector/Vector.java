package ru.academits.khudyakov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("–азмерность вектора \"" + dimension + "\" должна быть > 0");
        }

        components = new double[dimension];
    }

    public Vector(Vector vector) {
        int dimension = vector.components.length;

        components = Arrays.copyOf(vector.components, dimension);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("–азмерность вектора \"" + components.length + "\" должна быть > 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int dimension, double[] components) {
        if (dimension <= 0) { //|| components.length <= 0) { здесь может пусть будет массив длины 0?
            throw new IllegalArgumentException("–азмерность вектора \"" + dimension + "\" должна быть > 0");
        }

        this.components = Arrays.copyOf(components, dimension);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponent(int index) {
        if (index < 0 || index > components.length - 1) {
            throw new ArrayIndexOutOfBoundsException("«начение \"" + index + "\" выходит за границы массива. «начение индекса должно быть > 0 и < " + (components.length - 1));
        }

        return this.components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index > components.length - 1) {
            throw new ArrayIndexOutOfBoundsException("«начение \"" + index + "\" выходит за границы массива. «начение индекса должно быть > 0 и < " + (components.length - 1));
        }

        components[index] = value;
    }

    public double getLength() {
        double lengthSquare = 0;

        for (double component : components) {
            lengthSquare += component * component;
        }

        return Math.sqrt(lengthSquare);
    }

    public void add(Vector vector) {
        int dimension = components.length;
        int addendumDimension = vector.components.length;

        int resultDimension = Math.max(dimension, addendumDimension);
        int lesserVectorDimension = Math.min(dimension, addendumDimension);

        Vector greaterVector = (dimension > addendumDimension) ? this : vector;

        double[] resultComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultComponents[i] = components[i] + vector.components[i];
            } else {
                resultComponents[i] = greaterVector.components[i];
            }
        }

        components = resultComponents;
    }

    public void subtract(Vector vector) {
        int dimension = components.length;
        int subtrahendDimension = vector.components.length;

        int resultDimension = Math.max(dimension, subtrahendDimension);
        int lesserVectorDimension = Math.min(dimension, subtrahendDimension);

        double[] resultComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultComponents[i] = components[i] - vector.components[i];
            } else {
                if (dimension >= subtrahendDimension) {
                    resultComponents[i] = components[i];
                } else {
                    resultComponents[i] = -vector.components[i];
                }
            }
        }

        components = resultComponents;
    }

    public void multiplyOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void revert() {
        final int REVERSION_COEFFICIENT = -1;

        multiplyOnScalar(REVERSION_COEFFICIENT);
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
        int resultDimension = Math.min(vector1.components.length, vector2.components.length);

        double scalarProduct = 0;

        for (int i = 0; i < resultDimension; i++) {
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
