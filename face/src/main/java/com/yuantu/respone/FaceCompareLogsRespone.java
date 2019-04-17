package com.yuantu.respone;

import com.yuantu.entity.FaceCompareLogs;
import lombok.Data;

/**
 * Created by JINZONGFAN on 2019/4/17 10:57
 */
@Data
public class FaceCompareLogsRespone extends FaceCompareLogs {
    //传入图片 base64编码后
    private String inputImage;

    //结果图片 base64编码后
    private String resultImage;

}
