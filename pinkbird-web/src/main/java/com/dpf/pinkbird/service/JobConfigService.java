package com.dpf.pinkbird.service;

import com.dpf.pinkbird.bean.BatchJob;
import java.util.List;

public interface JobConfigService {
    List<BatchJob> batchJobList(BatchJob batchJob);
}
