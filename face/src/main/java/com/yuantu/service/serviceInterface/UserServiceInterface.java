package com.yuantu.service.serviceInterface;

import com.yuantu.entity.User;
import com.yuantu.request.UserRequest;

/**
 * User层接口
 * Created by JINZONGFAN on 2019/4/16 17:12
 * @AUTHOR JINZONGFAN
 */
public interface UserServiceInterface {
    /**
     * 保存用户
     * @param regUser
     * @return
     */
    User saveUser(UserRequest regUser);

    /**
     * 查询手机，身份证是否被注册过
     * @param checkUser
     * @return
     */
    boolean findRegistedUser(User checkUser);

    /**
     * 查询身份证是否被注册过
     * @param checkUser
     * @return
     */
    boolean findUserByIdNo(User checkUser);

    /**
     * 修改用户人脸信息
     * @param registedUser
     * @return
     */
    int updateUser(UserRequest registedUser);

    /**
     * 删除用户人脸信息
     * @param registedUser
     * @return
     */
    int deleteUser(UserRequest registedUser);

}
