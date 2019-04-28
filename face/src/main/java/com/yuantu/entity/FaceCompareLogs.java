package com.yuantu.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "face_compare_logs")
@ToString
public class FaceCompareLogs implements Serializable {
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
     * 日志Id
     */
    @Column(name = "logId")
    private Long logid;

    /**
     * 身份证号
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     *联系方式
     */
    @Column(name = "phone")
    private String phone;

    /**
     *结果
     */
    @Column(name = "result")
    private Integer result;

    /**
     *比对入参图片
     */
    @Column(name = "input_image")
    private String inputImage;

    /**
     *比对结果图片
     */
    @Column(name = "result_image")
    private String resultImage;

}