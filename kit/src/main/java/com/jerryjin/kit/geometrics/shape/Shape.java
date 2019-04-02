package com.jerryjin.kit.geometrics.shape;

import android.graphics.Path;

import com.jerryjin.kit.geometrics.point.Point;

import androidx.annotation.NonNull;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 10:48 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Version: 0.0.1
 * Description: An abstract class for shape.
 */
public abstract class Shape {

    protected abstract void innerClose(@NonNull Point anyPoint, @Square.PointPosition int pointPos);

    public abstract double computeArea();

    public abstract double computeCircumference();

    public abstract Path getPath();
}
