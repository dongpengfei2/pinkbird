package com.dpf.pinkbird.controller;

import com.dpf.pinkbird.bean.BatchJob;
import com.dpf.pinkbird.bean.CommonResult;
import com.dpf.pinkbird.bean.Pagination;
import com.dpf.pinkbird.service.JobConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("jobConfig")
@Api("作业配置类")
public class JobConfigController {

    @Autowired
    private JobConfigService jobConfigService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "作业列表接口", notes = "查看作业列表")
    public Object list(Pagination pagination) {
        return jobConfigService.batchJobList(pagination);
    }

    @RequestMapping(value = "{jobId}/status/{jobStatus}", method = RequestMethod.PUT)
    public Object updateStatus(@PathVariable String jobId, @PathVariable Integer jobStatus) {
        jobConfigService.updateStatus(jobId, jobStatus);
        return new CommonResult(200, "success");
    }

    @RequestMapping(value = "addJob", method = RequestMethod.POST)
    public Object addBatchJob(BatchJob batchJob) {
        jobConfigService.addBatchJob(batchJob);
        return new CommonResult(200, "ok");
    }
}
