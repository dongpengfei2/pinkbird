package com.dpf.pinkbird.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dpf.pinkbird.bean.BatchJob;
import com.dpf.pinkbird.bean.Pagination;
import com.dpf.pinkbird.mapper.BatchJobMapper;
import com.dpf.pinkbird.service.JobConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobConfigServiceImpl implements JobConfigService {

    @Autowired
    private BatchJobMapper batchJobMapper;

    @Override
    public IPage<BatchJob> batchJobList(Pagination pagination) {
        return batchJobMapper.selectPage(pagination);
    }

    @Override
    public void updateStatus(String jobId, Integer jobStatus) {
        batchJobMapper.updateJobStatus(jobId, jobStatus);
    }
}
