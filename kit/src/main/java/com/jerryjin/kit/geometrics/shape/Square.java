package com.jerryjin.kit.geometrics.shape;

import android.graphics.Path;
import android.util.Log;

import com.jerryjin.kit.ICopy;
import com.jerryjin.kit.PathHelper;
import com.jerryjin.kit.geometrics.point.Point;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 11:40 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Description:
 */
@SuppressWarnings("WeakerAccess")
public class Square extends Shape implements ICopy {

    public static final int LEFT_TOP = 0;
    public static final int RIGHT_TOP = 1;
    public static final int LEFT_BOTTOM = 2;
    public static final int RIGHT_BOTTOM = 3;
    public double edge;
    public Point pLeftTop;
    public Point pRightTop;
    public Point pLeftBottom;
    public Point pRightBottom;
    @PointPosition
    private int pointPos;

    public Square(double edge) {
        this(edge, new Point(0, 0), LEFT_BOTTOM);
    }

    public Square(double edge, @NonNull Point anyPoint, @PointPosition int pointPos) {
        this.edge = edge;
        innerClose(anyPoint, pointPos);
    }

    public Square(Square src) {
        this.edge = src.edge;
        this.pLeftTop = src.pLeftTop.copy();
        this.pRightTop = src.pRightTop.copy();
        this.pLeftBottom = src.pLeftBottom.copy();
        this.pRightBottom = src.pRightBottom.copy();
        this.pointPos = src.pointPos;
    }

    private void innerClose(@NonNull Point anyPoint, @PointPosition int pointPos) {
        switch (pointPos) {
            case LEFT_BOTTOM:
                pLeftBottom = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(0, edge);
                pRightTop = anyPoint.copy().offset(edge, edge);
                pRightBottom = anyPoint.copy().offset(edge, 0);
                break;
            case LEFT_TOP:
                pLeftTop = anyPoint.copy();
                pRightTop = anyPoint.copy().offset(edge, 0);
                pLeftBottom = anyPoint.copy().offset(0, -edge);
                pRightBottom = anyPoint.copy().offset(edge, -edge);
                break;
            case RIGHT_BOTTOM:
                pRightBottom = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(edge, edge);
                pRightTop = anyPoint.copy().offset(0, edge);
                pLeftBottom = anyPoint.copy().offset(-edge, 0);
                break;
            case RIGHT_TOP:
                pRightTop = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(-edge, 0);
                pLeftBottom = anyPoint.copy().offset(-edge, -edge);
                pRightBottom = anyPoint.copy().offset(0, -edge);
                break;
        }
    }

    @Override
    public double computeArea() {
        return Math.pow(edge, 2);
    }

    @Override
    public double computeCircumference() {
        return edge * 4;
    }

    @Override
    public Path getPath() {
        return PathHelper
                .with(new Path())
                .lineTo(pLeftTop)
                .lineTo(pRightTop)
                .lineTo(pLeftBottom)
                .lineTo(pRightBottom)
                .result();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return "Square{" +
                "edge=" + edge +
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

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
    @IntDef({LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM})
    @interface PointPosition {
    }
}
