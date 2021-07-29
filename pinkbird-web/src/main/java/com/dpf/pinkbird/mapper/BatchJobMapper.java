package com.dpf.pinkbird.mapper;

import com.dpf.pinkbird.bean.BatchJob;

public interface BatchJobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BatchJob record);

    int insertSelective(BatchJob record);

    BatchJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BatchJob record);

    int updateByPrimaryKey(BatchJob record);
}