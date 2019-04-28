package com.yuantu.faceUtils;

/**
 * Copyright 2019 bejson.com
 */

public class FaceResult {

    private double left;
    private double top;
    private int width;
    private int height;
    private int rotation;

    public void setLeft(double left) {
        this.left = left;
    }

    public double getLeft() {
        return left;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getTop() {
        return top;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "FaceResult{" +
                "left=" + left +
                ", top=" + top +
                ", width=" + width +
                ", height=" + height +
                ", rotation=" + rotation +
                '}';
    }
}