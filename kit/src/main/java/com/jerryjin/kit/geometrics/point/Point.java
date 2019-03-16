package com.jerryjin.kit.geometrics.point;

import com.jerryjin.kit.ICopy;

import java.util.Objects;

/**
 * Author: Jerry
 * Generated at: 2019/3/16 11:07 AM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Description:
 */
@SuppressWarnings("WeakerAccess")
public final class Point implements ICopy {
    public double x;
    public double y;
    public double z;

    public Point(double x, double y) {
        this(x, y, 0);
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point src) {
        this.x = src.x;
        this.y = src.y;
        this.z = src.z;
    }

    public void set(double x, double y) {
        set(x, y, 0);
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void negate() {
        x = -x;
        y = -y;
        z = -z;
    }

    public final Point offset(double dx, double dy) {
        return offset(dx, dy, 0);
    }

    public final Point offset(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
        return this;
    }


    public boolean equals(double x, double y, double z) {
        return this.x == x && this.y == y && this.z == z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public Point copy() {
        return new Point(this);
    }
}
