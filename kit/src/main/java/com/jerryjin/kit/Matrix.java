package com.jerryjin.kit;

import androidx.annotation.NonNull;

import static com.jerryjin.kit.MathHelper.getMaximumInt;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 10:43 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Description:
 */
@SuppressWarnings("WeakerAccess")
public class Matrix {
    /**
     * Like:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */

    public int columns;
    public int rows;
    public double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix(int columns, int rows) {
        this.values = inflateZeroMatrix(columns, rows);
        this.columns = columns;
        this.rows = rows;
    }


    public Matrix(int columns, double... value) throws IllegalArgumentException {
        if (value != null) {
            int valueNum = value.length;
            if (valueNum < columns || valueNum % columns != 0) {
                throw new IllegalArgumentException("The number of values has to equal to the power of columns.");
            }
            int rows = valueNum / columns;
            this.columns = columns;
            this.rows = rows;
            values = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    values[i][j] = value[i * columns + j];
                }
            }
        }
    }

    public Matrix(Matrix src) {
        this.values = src.values;
        this.columns = src.columns;
        this.rows = src.rows;
    }

    public static double[][] inflateZeroMatrix(int columns, int rows) {
        double[][] values = new double[rows][columns];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = 0;
            }
        }
        return values;
    }

    /**
     * Make sure whether the length of each row of the Matrix is same.
     *
     * @param values The matrix values.
     * @return True if the length of each row of the Matrix is same, false otherwise.
     */
    public static boolean checkMatrixArray(double[][] values) {
        if (values != null) {
            int rows = values.length;
            int[] columnSizeArray = new int[rows];
            for (int i = 0; i < rows; i++) {
                columnSizeArray[i] = values[i].length;
            }
            int maxColumnSize = getMaximumInt(columnSizeArray);

            for (int i : columnSizeArray) {
                if (maxColumnSize > i) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Make sure whether the length of each row of the Matrix is same.
     *
     * @param matrix The matrix to resolve.
     * @return True if the length of each row of the Matrix is same, false otherwise.
     */
    public static boolean checkMatrixArray(Matrix matrix) {
        if (matrix != null) {
            double[][] values = matrix.values;
            int rows = values.length;
            int[] columnSizeArray = new int[rows];
            for (int i = 0; i < rows; i++) {
                columnSizeArray[i] = values[i].length;
            }
            int maxColumnSize = getMaximumInt(columnSizeArray);

            for (int i : columnSizeArray) {
                if (maxColumnSize > i) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public double[][] getValues() {
        return values;
    }

    public void setValues(double[][] values) {
        this.values = values;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Matrix: \n");
        for (double[] value : values) {
            for (double aValue : value) {
                builder.append(aValue);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
