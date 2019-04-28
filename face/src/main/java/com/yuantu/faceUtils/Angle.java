package com.yuantu.faceUtils;

/**
 * Created by JINZONGFAN on 2019/4/16 14:31
 */
public class Angle {
    private double yaw;
    private double pitch;
    private double roll;

    @Override
    public String toString() {
        return "Angle{" +
                "yaw=" + yaw +
                ", pitch=" + pitch +
                ", roll=" + roll +
                '}';
    }

    public Angle() {
    }

    public Angle(double yaw, double pitch, double roll) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }
}
