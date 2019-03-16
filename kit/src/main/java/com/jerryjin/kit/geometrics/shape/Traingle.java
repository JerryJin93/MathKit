package com.jerryjin.kit.geometrics.shape;

import android.graphics.Path;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 10:54 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Description:
 */
public class Traingle extends Shape {

    private float angleA;
    private float angleB;
    private float angleC;
    private double edgeA;
    private double edgeB;
    private double edgeC;

    public Traingle(float angleA, float angleB, float angleC,
                    double edgeA, double edgeB, double edgeC) {
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    @Override
    public double computeArea() {
        double p = (edgeA + edgeB + edgeC) / 2;
        return Math.sqrt((p - edgeA) * (p - edgeB) * (p - edgeC));
    }

    @Override
    public double computeCircumference() {
        return edgeA + edgeB + edgeC;
    }

    @Override
    public Path getPath() {
        return null;
    }

}
