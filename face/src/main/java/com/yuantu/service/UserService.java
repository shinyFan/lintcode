package com.yuantu.service;

import com.yuantu.dao.UserExtMapper;
import com.yuantu.dao.UserMapper;
import com.yuantu.entity.User;
import com.yuantu.faceUtils.FileUtil;
import com.yuantu.faceUtils.ImageToBase64;
import com.yuantu.request.UserRequest;
import com.yuantu.service.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by JINZONGFAN on 2019/4/16 17:11
 */

/**
 * 用户业务层
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserExtMapper userMapper;

    @Autowired
    ImageToBase64 util;

    @Value("${image.base.path}")
    private String IMAGE_BASE_PATH;

    @Transactional
    @Override
    public User saveUser(UserRequest regUser) {
        //1.属性拷贝
        User user=this.getOperateUser(regUser);
        //2.插入记录返回id
        int result=userMapper.insertSelectiveBackId(user);
        if(regUser.getImage()!=null){
            //3.保存图片到图片服务器更新用户信息
            result = saveImageAndUser(regUser, user,"add");
        }
        return result>0?user:null;
    }

    @Override
    public boolean findRegistedUser(User checkUser) {
        User user=new User();
        //手机号
        user.setPhone(checkUser.getPhone());
        //身份证
        user.setIdNo(checkUser.getIdNo());

        return userMapper.findUserByPhoneOrIdNO(user).size()>0?true:false;
    }

    @Override
    public boolean findUserByIdNo(User checkUser) {
        User user=new User();
        //身份证
        user.setIdNo(checkUser.getIdNo());

        return userMapper.findUserByPhoneOrIdNO(user).size()>0?true:false;
    }


    @Transactional
    @Override
    public int updateUser(UserRequest registedUser) {
        User modifyUser = this.getOperateUser(registedUser);
        User checkUser=new User();
        //1.设置身份证
        checkUser.setIdNo(registedUser.getIdNo());
        List<User> userByPhoneOrIdNO = userMapper.findUserByPhoneOrIdNO(checkUser);
        //2.查询要修改的用户信息
        if(!userByPhoneOrIdNO.isEmpty()){
            checkUser=userByPhoneOrIdNO.get(0);
        }
        modifyUser.setId(checkUser.getId());
        //3,更新用户信息
        int result = this.saveImageAndUser(registedUser, modifyUser,"update");
        return result;
    }

    @Override
    public int deleteUser(UserRequest registedUser) {
        //根据身份证号查询用户；
        User checkUser=new User();
        int result=0;
        //1.设置身份证
        checkUser.setIdNo(registedUser.getIdNo());
        List<User> userByPhoneOrIdNO = userMapper.findUserByPhoneOrIdNO(checkUser);
        if(!userByPhoneOrIdNO.isEmpty()){
            User delUser = userByPhoneOrIdNO.get(0);
            String faceImgUrl = delUser.getFaceImgUrl();
            //根据id删除用户
            result = userMapper.deleteByPrimaryKey(delUser.getId());
            //删除成功，移除图像
            if(result>0){
                FileUtil.judeFileExists(IMAGE_BASE_PATH+faceImgUrl);
            }
        }
        return result;
    }

    public User getOperateUser(UserRequest regUser){
        User user=new User();
        //注册的话 id为null
        if(regUser.getService()!=null&&regUser.getService().contains("reg")){
            user.setId(null);
        }else{
            user.setId(regUser.getId());
        }

        user.setExtend(regUser.getExtend());

        //TODO
        //1.调用第三方获得生物特征
        user.setFaceVector(null);
        user.setIdNo(regUser.getIdNo());
        user.setName(regUser.getName());
        user.setPhone(regUser.getPhone());
        user.setGmtCreate(new Date());
        user.setGmtModify(new Date());
        return user;
    }

    public int saveImageAndUser(UserRequest regUser,User user,String type){
        regUser.setId(user.getId());
        //1.将图片保存到图片服务启
        String faceImgUrl = util.getPicFormatBASE64(regUser);
        regUser.setInputImage(faceImgUrl);
        //2.保存图片路径
        User newUser=new User();
        int result=0;
        if("add".equals(type)){
            newUser.setId(user.getId());
            newUser.setFaceImgUrl(faceImgUrl);
            user.setFaceImgUrl(faceImgUrl);
            //3.修改用户
            result = userMapper.updateByPrimaryKeySelective(newUser);
        }else if("update".equals(type)){
            user.setFaceImgUrl(faceImgUrl);
            //3.修改用户
            result = userMapper.updateByPrimaryKeySelective(user);
        }
        return result;
    }

}
