package com.jerryjin.kit.geometrics.shape;

import android.graphics.Path;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 10:52 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Description: Rectangle.
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new ArithmeticException("Both width and height of a rectangle must be positive.");
        } else {
            this.width = width;
            this.height = height;
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
        return null;
    }


}
