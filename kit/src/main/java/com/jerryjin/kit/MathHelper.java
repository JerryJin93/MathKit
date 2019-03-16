package com.jerryjin.kit;

import android.graphics.Point;

import androidx.annotation.NonNull;
import androidx.annotation.Size;


@SuppressWarnings("WeakerAccess")
public class MathHelper {

    public static final int ERROR_PARAMETER = -1;

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
    public static final Matrix SAMPLE_1 = new Matrix(3, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    /**
     * 1
     * 2
     * 3
     */
    public static final Matrix SAMPLE_2 = new Matrix(1, 1, 2, 3);

    private MathHelper() {

    }

    /**
     * Matrix A multiplies by Matrix B.
     *
     * @param left  The left matrix.
     * @param right The right matrix.
     * @return The result matrix.
     */
    public static Matrix multiply(Matrix left, Matrix right) {
        if (Matrix.checkMatrixArray(left) && Matrix.checkMatrixArray(right)) {
            Matrix result = new Matrix(left.rows, right.columns);
            for (int i = 0; i < result.rows; i++) {
                for (int j = 0; j < result.columns; j++) {
                    result.values[i][j] = computeSingleCell(left, right, i, j);
                }
            }
            return result;
        }
        return null;
    }

    private static double computeSingleCell(Matrix mA, Matrix mB, int column, int row) {
        if (mA != null && mB != null) {
            double[][] mAValues = mA.values;
            double[][] mBValues = mB.values;
            double result = 0;
            for (int i = 0; i < mAValues[0].length; i++) {
                result += mAValues[row][i] * mBValues[i][column];
            }
            return result;
        }
        return ERROR_PARAMETER;
    }


    public static double computeSlope(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double computeDistance(Point pointA, Point pointB) {
        if (pointA == null || pointB == null) {
            return ERROR_PARAMETER;
        }
        return computeSlope(pointA.x - pointB.x, pointA.y - pointB.y);
    }

    public static double computeDistance(@Size(2) int[] pointA, @Size(2) int[] pointB) {
        if (pointA == null || pointA.length == 0 || pointB == null || pointB.length == 0) {
            return ERROR_PARAMETER;
        }
        int xA, xB, yA, yB;
        xA = pointA[0];
        xB = pointB[0];
        yA = pointA[1];
        yB = pointB[1];
        return computeDistance(new Point(xA, yA), new Point(xB, yB));
    }

    public static double computeDistance(int xA, int yA, int xB, int yB) {
        return computeDistance(new Point(xA, yA), new Point(xB, yB));
    }

    public static int getMaximumInt(int[] values) {
        if (values != null) {
            int max = values[0];
            for (int i : values) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        } else {
            return ERROR_PARAMETER;
        }
    }

    public static int getMinimumInt(int[] values) {
        if (values != null) {
            int min = values[0];
            for (int i : values) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        }
        return ERROR_PARAMETER;
    }


    public interface Func {
        double func(int len, double... x);
    }


}
