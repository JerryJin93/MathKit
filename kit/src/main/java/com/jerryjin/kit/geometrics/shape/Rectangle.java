package com.jerryjin.kit.geometrics.shape;

import android.graphics.Path;

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
 * Generated at: 2019/3/16 10:52 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Version: 0.0.1
 * Description: Rectangle.
 */
@SuppressWarnings("WeakerAccess")
public class Rectangle extends Shape implements ICopy {

    public static final int LEFT_TOP = 0;
    public static final int RIGHT_TOP = 1;
    public static final int LEFT_BOTTOM = 2;
    public static final int RIGHT_BOTTOM = 3;

    protected double width;
    protected double height;

    protected Point pLeftTop;
    protected Point pRightTop;
    protected Point pLeftBottom;
    protected Point pRightBottom;
    @PointPosition
    protected int pointPos;

    public Rectangle(double width, double height) {
        this(width, height, new Point(0, 0), LEFT_BOTTOM);
    }

    public Rectangle(double width, double height, @NonNull Point anyPoint, @PointPosition int pointPos) {
        if (width < 0 || height < 0) {
            throw new ArithmeticException("Both width and height of a rectangle must be positive.");
        } else {
            this.width = width;
            this.height = height;
        }
        innerClose(anyPoint, pointPos);
    }

    public Rectangle(Rectangle src) {
        this.width = src.width;
        this.height = src.height;
        this.pLeftTop = src.pLeftTop.copy();
        this.pRightTop = src.pRightTop.copy();
        this.pLeftBottom = src.pLeftBottom.copy();
        this.pRightBottom = src.pRightBottom.copy();
        this.pointPos = src.pointPos;
    }

    @Override
    protected void innerClose(@NonNull Point anyPoint, int pointPos) {
        switch (pointPos) {
            case LEFT_BOTTOM:
                pLeftBottom = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(0, height);
                pRightTop = anyPoint.copy().offset(width, height);
                pRightBottom = anyPoint.copy().offset(width, 0);
                break;
            case LEFT_TOP:
                pLeftTop = anyPoint.copy();
                pRightTop = anyPoint.copy().offset(width, 0);
                pLeftBottom = anyPoint.copy().offset(0, -height);
                pRightBottom = anyPoint.copy().offset(width, -height);
                break;
            case RIGHT_BOTTOM:
                pRightBottom = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(width, height);
                pRightTop = anyPoint.copy().offset(0, height);
                pLeftBottom = anyPoint.copy().offset(-width, 0);
                break;
            case RIGHT_TOP:
                pRightTop = anyPoint.copy();
                pLeftTop = anyPoint.copy().offset(-width, 0);
                pLeftBottom = anyPoint.copy().offset(-width, -height);
                pRightBottom = anyPoint.copy().offset(0, -height);
                break;
        }
    }

    @Override
    public double computeArea() {
        return width * height;
    }

    @Override
    public double computeCircumference() {
        return (width + height) * 2;
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
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", pLeftTop=" + pLeftTop +
                ", pRightTop=" + pRightTop +
                ", pLeftBottom=" + pLeftBottom +
                ", pRightBottom=" + pRightBottom +
                ", pointPos=" + pointPos +
                '}';
    }

    @Override
    public Object copy() {
        return new Rectangle(this);
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
    @IntDef({LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM})
    @interface PointPosition {
    }
}
