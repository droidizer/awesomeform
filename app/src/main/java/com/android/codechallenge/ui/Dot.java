package com.android.codechallenge.ui;

import android.graphics.Point;
import com.android.codechallenge.utils.ChartUtils;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by greymatter on 15/03/16.
 */
class Dot {
    int x;
    int y;
    int data;
    int targetX;
    int targetY;
    int linenumber;
    int velocity = ChartUtils.dip2px(getContext(), 18);

    Dot(int x, int y, int targetX, int targetY, Integer data, int linenumber) {
        this.x = x;
        this.y = y;
        this.linenumber = linenumber;
        setTargetData(targetX, targetY, data, linenumber);
    }

    Point setupPoint(Point point) {
        point.set(x, y);
        return point;
    }

    Dot setTargetData(int targetX, int targetY, Integer data, int linenumber) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.data = data;
        this.linenumber = linenumber;
        return this;
    }

    boolean isAtRest() {
        return (x == targetX) && (y == targetY);
    }

    void update() {
        x = updateSelf(x, targetX, velocity);
        y = updateSelf(y, targetY, velocity);
    }

    private int updateSelf(int origin, int target, int velocity) {
        if (origin < target) {
            origin += velocity;
        } else if (origin > target) {
            origin -= velocity;
        }
        if (Math.abs(target - origin) < velocity) {
            origin = target;
        }
        return origin;
    }
}
