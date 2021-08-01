package com.dpf.pinkbird.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dpf.pinkbird.bean.BatchJob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BatchJobMapper extends BaseMapper<BatchJob> {
    @Select("select * from job_batch")
    IPage<BatchJob> selectPage(IPage<BatchJob> page);
    @Update("update job_batch set job_status=#{jobStatus} where job_id=#{jobId}")
    void updateJobStatus(@Param("jobId") String jobId, @Param("jobStatus") Integer jobStatus);
}