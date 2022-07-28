package ru.academits.khudyakov.vector;

import java.util.Arrays;

public class Vector {
    private final int vectorDimension;
    private final double[] components;

    public Vector(int vectorDimension) {
        if (vectorDimension <= 0) {
            throw new IllegalArgumentException();
        }

        this.vectorDimension = vectorDimension;
        components = new double[this.vectorDimension];
        Arrays.fill(components, 0);
    }

    public Vector(Vector vector) {
        vectorDimension = vector.vectorDimension;
        components = new double[vectorDimension];
        System.arraycopy(vector.components, 0, components, 0, vectorDimension);
    }

    public Vector(double[] components) {
        vectorDimension = components.length;
        this.components = new double[vectorDimension];
        System.arraycopy(components, 0, this.components, 0, vectorDimension);
    }

    public Vector(int vectorDimension, double[] components) {
        if (vectorDimension <= 0) {
            throw new IllegalArgumentException();
        }

        this.vectorDimension = vectorDimension;
        this.components = new double[vectorDimension];

        Arrays.fill(this.components, 0);
        System.arraycopy(components, 0, this.components, 0, components.length);
    }

    public int getSize() {
        return vectorDimension;
    }

    public double getVectorComponent(int index) {
        if (index < 0 || index > vectorDimension) {
            throw new IllegalArgumentException();
        }

        return this.components[index];
    }

    public void setVectorComponent(int index, double value) {
        if (index < 0 || index > vectorDimension) {
            throw new IllegalArgumentException();
        }

        this.components[index] = value;
    }

    public double getVectorLength() {
        double vectorLength = 0;

        for (double component : components) {
            vectorLength += component * component;
        }

        return Math.sqrt(vectorLength);
    }

    public Vector addVector(Vector vector) {
        int resultDimension = Math.max(vectorDimension, vector.vectorDimension);
        int lesserVectorDimension = Math.min(vectorDimension, vector.vectorDimension);

        double[] resultVectorComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultVectorComponents[i] = components[i] + vector.components[i];
            } else {
                Vector greaterVector = (vectorDimension > vector.vectorDimension) ? this : vector;
                resultVectorComponents[i] = greaterVector.components[i] + 0;
            }
        }

        return new Vector(resultDimension, resultVectorComponents);
    }

    public Vector subtractVector(Vector vector) {
        int resultDimension = Math.max(vectorDimension, vector.vectorDimension);
        int lesserVectorDimension = Math.min(vectorDimension, vector.vectorDimension);

        double[] resultVectorComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultVectorComponents[i] = components[i] - vector.components[i];
            } else {
                if (vectorDimension >= vector.vectorDimension) {
                    resultVectorComponents[i] = components[i] - 0;
                } else {
                    resultVectorComponents[i] = 0 - vector.components[i];
                }
            }
        }

        return new Vector(resultDimension, resultVectorComponents);
    }

    public void scalarMultiply(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar;
        }
    }

    public void revertVector() {
        final int REVERSION_COEFFICIENT = -1;

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * REVERSION_COEFFICIENT;
        }
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        int resultDimension = Math.max(vector1.vectorDimension, vector2.vectorDimension);
        int lesserVectorDimension = Math.min(vector1.vectorDimension, vector2.vectorDimension);

        double[] resultVectorComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultVectorComponents[i] = vector1.components[i] + vector2.components[i];
            } else {
                Vector greaterVector = (vector1.vectorDimension > vector2.vectorDimension) ? vector1 : vector2;
                resultVectorComponents[i] = greaterVector.components[i] + 0;
            }
        }

        return new Vector(resultDimension, resultVectorComponents);
    }

    public static Vector getVectorsDifference(Vector vector1, Vector vector2) {
        int resultDimension = Math.max(vector1.vectorDimension, vector2.vectorDimension);
        int lesserVectorDimension = Math.min(vector1.vectorDimension, vector2.vectorDimension);

        double[] resultVectorComponents = new double[resultDimension];

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                resultVectorComponents[i] = vector1.components[i] - vector2.components[i];
            } else {
                if (vector1.vectorDimension >= vector2.vectorDimension) {
                    resultVectorComponents[i] = vector1.components[i] - 0;
                } else {
                    resultVectorComponents[i] = 0 - vector2.components[i];
                }
            }
        }

        return new Vector(resultDimension, resultVectorComponents);
    }

    public static double getVectorsScalarProduct(Vector vector1, Vector vector2) {
        int resultDimension = Math.max(vector1.vectorDimension, vector2.vectorDimension);
        int lesserVectorDimension = Math.min(vector1.vectorDimension, vector2.vectorDimension);

        Vector greaterVector = (vector1.vectorDimension > vector2.vectorDimension) ? vector1 : vector2;

        double scalarProduct = 0;

        for (int i = 0; i < resultDimension; i++) {
            if (i < lesserVectorDimension) {
                scalarProduct += vector1.components[i] * vector2.components[i];
            } else {
                scalarProduct += greaterVector.components[i] * 0;
            }
        }

        return scalarProduct;
    }

    @Override
    public String toString() {
        if (components == null) {
            return "null";
        }

        int iMax = components.length - 1;
        if (iMax == -1) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (int i = 0; ; i++) {
            stringBuilder.append(components[i]);

            if (i == iMax) {
                return stringBuilder.append('}').toString();
            }

            stringBuilder.append(", ");
        }
    }
}
