package com.yuantu.dao;

import com.yuantu.entity.FaceCompareLogs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FaceCompareLogsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FaceCompareLogs record);

    int insertSelective(FaceCompareLogs record);

    FaceCompareLogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FaceCompareLogs record);

    int updateByPrimaryKey(FaceCompareLogs record);
}