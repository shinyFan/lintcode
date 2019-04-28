package com.yuantu.controller;

import com.yuantu.common.Result;
import com.yuantu.entity.FaceCompareLogs;
import com.yuantu.entity.User;
import com.yuantu.faceUtils.LogsUtil;
import com.yuantu.faceUtils.StrToObjectUtil;
import com.yuantu.request.UserRequest;
import com.yuantu.service.serviceInterface.FaceCompareLogsServiceInterface;
import com.yuantu.service.serviceInterface.UserServiceInterface;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by JINZONGFAN on 2019/4/16 17:41
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private FaceCompareLogsServiceInterface faceCompareLogsServiceInterface;

    /**
     * 人脸注册
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/register")
    @ApiOperation(value="用户人脸注册")
    public Result register(@RequestBody String body){
        UserRequest regUser = null;
        FaceCompareLogs log=new FaceCompareLogs();
        Result result = null;
        try {
            regUser = (UserRequest) StrToObjectUtil.strToObject(body, UserRequest.class);
            //判断用户是否存在
            boolean exist = userServiceInterface.findRegistedUser(regUser);
            if(exist){
                return Result.createFailResult("用户已被注册");
            }

            // log.setInputImage(regUser.getImage());
            User user = userServiceInterface.saveUser(regUser);
            if(user!=null){
                //记录
                LogsUtil.printLogs(logger,regUser);
                //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);

                result=Result.createSuccessResult(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);

            result=Result.createFailResult();
        }
        return  result;
    }


    @ResponseBody
    @PostMapping(value = "/checkUser")
    @ApiOperation(value="根据用户唯一性信息查询是否注册过")
    public Result checkUser(@RequestBody User checkUser){
        Result result = null;
        try {
            //存在返回ture
            boolean registedUser = userServiceInterface.findRegistedUser(checkUser);
            //若用户存在返回成功信息
            if(registedUser){
                result=Result.createSuccessResult();
            }else{
                result=Result.createFailResult();
            }
        }catch (Exception e){
            result=Result.createFailResult("查询用户出错");
        }
        return  result;
    }


    /**
     * 人脸更新
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @ApiOperation(value="用户人脸更新")
    public Result update(@RequestBody String body){
        Result result = null;
        FaceCompareLogs log=new FaceCompareLogs();
        UserRequest regUser = null;
        try {
            regUser = (UserRequest) StrToObjectUtil.strToObject(body, UserRequest.class);

            //判断身份证号是否存在
            boolean registedUser = userServiceInterface.findUserByIdNo(regUser);
            if(registedUser){
                LogsUtil.printLogs(logger,regUser);
                //记录
                userServiceInterface.updateUser(regUser);
                //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);

                result=Result.createSuccessResult();
            }else{
                log.setResult(-1);
                result=Result.createFailResult("身份证号不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);
            result=Result.createFailResult();
        }
        return  result;
    }

    /**
     * 人脸删除
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/delete")
    @ApiOperation(value="用户人脸删除")
    public Result delete(@RequestBody String body){
        Result result = null;
        FaceCompareLogs log=new FaceCompareLogs();
        UserRequest regUser = null;
        try {

            regUser = (UserRequest) StrToObjectUtil.strToObject(body, UserRequest.class);
            //判断身份证号是否存在
            boolean registedUser = userServiceInterface.findUserByIdNo(regUser);
            //User user = userServiceInterface.saveUser(regUser);
            if(registedUser){
                int del = userServiceInterface.deleteUser(regUser);
                if(del>0){
                    //记录
                    LogsUtil.printLogs(logger,regUser);
                    log.setResult(1);
                    //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);
                    result=Result.createSuccessResult();
                }else{
                    result=Result.createFailResult("删除失败");
                }

            }else{
                result=Result.createFailResult("身份证号不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            //faceCompareLogsServiceInterface.addFaceCompareLogs(regUser,log);
            result=Result.createFailResult();
        }
        return  result;
    }


}
