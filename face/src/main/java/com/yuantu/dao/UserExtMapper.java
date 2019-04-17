package com.yuantu.dao;

import com.yuantu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JINZONGFAN on 2019/4/17 8:56
 */
@Repository
@Mapper
public interface UserExtMapper extends UserMapper {
    /**
     * 根据手机，身份证等信息查询用户
     * @param checkUser
     * @return
     */
    List<User> findUserByPhoneOrIdNO(User checkUser);

    /**
     * 插入后返回主键id
     * @param record
     * @return
     */
    int insertSelectiveBackId(User record);


}
