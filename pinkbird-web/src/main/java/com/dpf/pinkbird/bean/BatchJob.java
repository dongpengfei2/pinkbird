package com.dpf.pinkbird.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("job_batch")
public class BatchJob {
    private Integer id;

    private String jobId;

    private String jobName;

    private Integer jobStatus;

    private String pathJar;

    private String pathSavepoint;

    private Integer enableSavepoint;

    private Integer jmMem;

    private Integer tmMem;

    private Integer yarnslots;

    private Integer parallelism;

    private String className;

    private String classArgs;

    private Integer createUserid;

    private Date createAt;

    private Integer updateUserid;

    private Date updateAt;
}