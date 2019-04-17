package com.yuantu.faceUtils;

/**
 * Created by JINZONGFAN on 2019/4/16 14:28
 */
public class Face {
    private String face_token;
    private Location location;
    private int face_probability;
    private Angle angle;

    @Override
    public String toString() {
        return "Face{" +
                "face_token='" + face_token + '\'' +
                ", location=" + location +
                ", face_probability=" + face_probability +
                ", angle=" + angle +
                '}';
    }

    public Face(String face_token, Location location, int face_probability, Angle angle) {
        this.face_token = face_token;
        this.location = location;
        this.face_probability = face_probability;
        this.angle = angle;
    }

    public Face() {
    }

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getFace_probability() {
        return face_probability;
    }

    public void setFace_probability(int face_probability) {
        this.face_probability = face_probability;
    }

    public Angle getAngle() {
        return angle;
    }

    public void setAngle(Angle angle) {
        this.angle = angle;
    }
}
