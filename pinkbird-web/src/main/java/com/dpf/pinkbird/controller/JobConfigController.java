package com.dpf.pinkbird.controller;

import com.dpf.pinkbird.bean.BatchJob;
import com.dpf.pinkbird.bean.Pagination;
import com.dpf.pinkbird.service.JobConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object list(Pagination pagination, BatchJob batchJob) {
        return jobConfigService.batchJobList(pagination);
    }
}
