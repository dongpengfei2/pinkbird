package com.dpf.pinkbird.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dpf.pinkbird.bean.BatchJob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BatchJobMapper extends BaseMapper<BatchJob> {
    @Select("select * from job_batch")
    IPage<BatchJob> selectPage(@Param("pg") IPage<BatchJob> page, @Param("batchJob") BatchJob batchJob);
}