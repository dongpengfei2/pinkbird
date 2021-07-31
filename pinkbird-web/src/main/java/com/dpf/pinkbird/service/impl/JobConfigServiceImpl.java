package com.dpf.pinkbird.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpf.pinkbird.bean.BatchJob;
import com.dpf.pinkbird.bean.Pagination;
import com.dpf.pinkbird.mapper.BatchJobMapper;
import com.dpf.pinkbird.service.JobConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobConfigServiceImpl implements JobConfigService {

    @Autowired
    private BatchJobMapper batchJobMapper;

    @Override
    public IPage<BatchJob> batchJobList(Pagination pagination) {
        IPage<BatchJob> jobPage = new Page<BatchJob>(pagination.getPageNum(), pagination.getPageSize());
        QueryWrapper<BatchJob> queryWrapper = new QueryWrapper<BatchJob>();
        jobPage = batchJobMapper.selectPage(jobPage, queryWrapper);
        queryWrapper.last("limit " + (pagination.getPageNum() - 1) * pagination.getPageSize() + ", " + pagination.getPageSize());
        final List<BatchJob> batchJobs = batchJobMapper.selectList(queryWrapper);
        jobPage.setRecords(batchJobs);
        return jobPage;
    }
}
