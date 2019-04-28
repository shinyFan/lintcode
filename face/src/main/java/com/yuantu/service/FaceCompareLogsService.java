package com.yuantu.service;

import com.yuantu.dao.FaceCompareLogsMapper;
import com.yuantu.entity.FaceCompareLogs;
import com.yuantu.request.UserRequest;
import com.yuantu.respone.FaceCompareLogsRespone;
import com.yuantu.service.serviceInterface.FaceCompareLogsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 日志业务层
 * Created by JINZONGFAN on 2019/4/16 17:14
 */
@Service
public class FaceCompareLogsService implements FaceCompareLogsServiceInterface {
    @Autowired
    private FaceCompareLogsMapper faceCompareLogsMapper;

    @Override
    public int addFaceCompareLogs(UserRequest user, FaceCompareLogs log) {
        FaceCompareLogs logs=new FaceCompareLogs();
        logs.setGmtCreate(new Date());
        logs.setGmtModify(new Date());
        logs.setLogid(user.getLogId());
        logs.setIdNo(user.getIdNo());
        logs.setPhone(user.getPhone());
        logs.setResult(log.getResult());
        logs.setInputImage(user.getInputImage());
        logs.setResultImage(user.getResultImage());
        int result = faceCompareLogsMapper.insertSelective(logs);
        return result;
    }
}
