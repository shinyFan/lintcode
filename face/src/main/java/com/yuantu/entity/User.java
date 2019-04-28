package com.yuantu.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
@ToString
public class User implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID =  -5809782578272943999L;

    /**
     *  唯一id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 身份证号
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     *联系方式
     */
    @Column(name = "phone")
    private String phone;

    /**
     *图片路径
     */
    @Column(name = "face_img_url")
    private String faceImgUrl;

    /**
     *人脸特征
     */
    @Column(name = "face_vector")
    private String faceVector;

    /**
     * 用户扩展
     */
    @Column(name = "extend")
    private String extend;
}