package com.dpf.pinkbird.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dpf.pinkbird.bean.BatchJob;
import com.dpf.pinkbird.bean.Pagination;

public interface JobConfigService {
    IPage<BatchJob> batchJobList(Pagination pagination);
    void updateStatus(String jobId, Integer jobStatus);
}
