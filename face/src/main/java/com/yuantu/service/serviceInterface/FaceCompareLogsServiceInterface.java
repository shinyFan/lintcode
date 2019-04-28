package com.yuantu.service.serviceInterface;

import com.yuantu.entity.FaceCompareLogs;
import com.yuantu.entity.User;
import com.yuantu.request.UserRequest;
import com.yuantu.respone.FaceCompareLogsRespone;

/**
 * Created by JINZONGFAN on 2019/4/16 17:15
 */
public interface FaceCompareLogsServiceInterface {
    /**
     * 添加日志
     * @param user
     * @param log
     * @return
     */
    int addFaceCompareLogs(UserRequest user, FaceCompareLogs log);
}
