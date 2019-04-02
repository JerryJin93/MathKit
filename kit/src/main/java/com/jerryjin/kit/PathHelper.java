package com.jerryjin.kit;

import android.graphics.Path;

import com.jerryjin.kit.geometrics.point.Point;


/**
 * Author: Jerry
 * Generated at: 2019/3/16 12:30 PM
 * GitHub: https://github.com/JerryJin93
 * Blog:
 * WeChat: enGrave93
 * Version: 0.0.1
 * Description:
 */
public class PathHelper {

    private Path path;

    private PathHelper() {

    }

    public static PathHelper with(Path path) {
        PathHolder.instance.path = path;
        return PathHolder.instance;
    }

    public PathHelper lineTo(Point point) {
        if (point != null) {
            path.lineTo((int) point.x, (int) point.y);
        }
        return this;
    }

    public PathHelper lineTo(Point[] points) {
        if (points != null && points.length > 0) {
            for (Point point : points) {
                path.lineTo((int) point.x, (int) point.y);
            }
        }
        return this;
    }

    public Path result() {
        return path;
    }

    private static class PathHolder {
        private static final PathHelper instance = new PathHelper();
    }
}
