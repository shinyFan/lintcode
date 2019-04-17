package com.yuantu.faceUtils;

import com.yuantu.request.UserRequest;
import org.slf4j.Logger;

import java.util.Date;

/**
 * Created by JINZONGFAN on 2019/4/17 11:07
 */
public class LogsUtil {
    public  static void printLogs(Logger Logger, UserRequest user){
        //获得用户姓名
        String name = user.getName();
        String idNo = user.getIdNo();
        String phone = user.getPhone();
        String service = user.getService();
        String time = DateStringUtils.DateToString(new Date());
        StringBuilder info=new StringBuilder();
        info.append(time);
        info.append(" ");
        info.append(name);
        info.append("(");
        info.append(idNo);
        info.append(" )");
        info.append(" ");
        info.append(phone);
        info.append("使用了");
        info.append(service);
        Logger.info(info.toString());
    }
}
