package com.android.codechallenge.model;

/**
 * Created by greymatter on 14/03/16.
 */
public class DataPoint {

    public int x;

    public double y;

    public DataPoint setX(int x) {
        this.x = x;
        return this;
    }

    public DataPoint setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (x != dataPoint.x) return false;
        if (Double.compare(dataPoint.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = x;
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
