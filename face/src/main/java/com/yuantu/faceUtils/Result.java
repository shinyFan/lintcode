package com.yuantu.faceUtils;

import java.util.List;

/**
 * Created by JINZONGFAN on 2019/4/16 14:27
 */
public class Result {
    private int face_num;
    private List<Face> face_list;
    private double score;


    public int getFace_num() {
        return face_num;
    }

    public void setFace_num(int face_num) {
        this.face_num = face_num;
    }

    public List<Face> getFace_list() {
        return face_list;
    }

    public void setFace_list(List<Face> face_list) {
        this.face_list = face_list;
    }

    public Result() {
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Result(int face_num, List<Face> face_list, double score) {
        this.face_num = face_num;
        this.face_list = face_list;
        this.score = score;
    }
}
