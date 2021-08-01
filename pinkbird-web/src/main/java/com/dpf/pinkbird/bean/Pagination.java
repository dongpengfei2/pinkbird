package com.dpf.pinkbird.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Pagination<T> extends Page<T> {
    private String query;
    private int pageNum;
    private int pageSize;

    public Pagination(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }
}
