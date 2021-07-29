package com.dpf.pinkbird.service.impl;

import com.dpf.pinkbird.bean.BatchJob;
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
    public List<BatchJob> batchJobList(BatchJob batchJob) {
        return batchJobMapper.selectList(null);
    }
}
