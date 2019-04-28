package com.yuantu.faceUtils;

/**
 * Created by JINZONGFAN on 2019/4/16 14:31
 */
public class Location {
    private double left;
    private double top;
    private int width;
    private int height;
    private int rotation;

    @Override
    public String toString() {
        return "Location{" +
                "left=" + left +
                ", top=" + top +
                ", width=" + width +
                ", height=" + height +
                ", rotation=" + rotation +
                '}';
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public Location(double left, double top, int width, int height, int rotation) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }

    public Location() {
    }
}
