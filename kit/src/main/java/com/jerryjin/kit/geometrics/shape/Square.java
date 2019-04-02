package com.jerryjin.kit.geometrics.shape;

import com.jerryjin.kit.ICopy;
import com.jerryjin.kit.geometrics.point.Point;

import androidx.annotation.NonNull;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 11:40 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Version: 0.0.1
 * Description:
 */
@SuppressWarnings("WeakerAccess")
public class Square extends Rectangle implements ICopy {

    public Square(double edge) {
        super(edge, edge);
    }

    public Square(double edge, @NonNull Point anyPoint, @PointPosition int pointPos) {
        super(edge, edge, anyPoint, pointPos);
    }

    public Square(Square src) {
        super(src);
    }

    @Override
    public double computeArea() {
        return Math.pow(width, 2);
    }

    @Override
    public double computeCircumference() {
        return width * 4;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return "Square{" +
                "edge=" + width +
                ", pLeftTop=" + pLeftTop +
                ", pRightTop=" + pRightTop +
                ", pLeftBottom=" + pLeftBottom +
                ", pRightBottom=" + pRightBottom +
                ", pointPos=" + pointPos +
                '}';
    }

    @Override
    public Square copy() {
        return new Square(this);
    }

}
