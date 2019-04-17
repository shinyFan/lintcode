package com.yuantu.common;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author hanlimin
 * @Description: 分页
 * @email hanlimin@yuantutech.com
 * @date 2018/6/26
 */
@ApiModel("分页实体")
@Data
public class PageResultContent<T> {
    @ApiModelProperty("页码")
    private int page;
    @ApiModelProperty("每页长度")
    private int size;
    @ApiModelProperty("总页数")
    private int total;
    @ApiModelProperty("数据")
    private List<T> value;

    public static <T> PageResultContent<T> createPageResultContent(PageInfo<T> pageInfo) {
        return new PageResultContent<T>(pageInfo);
    }

    public PageResultContent(PageInfo<T> pageInfo) {
        this.page = pageInfo.getPageNum();
        this.size = pageInfo.getPageSize();
        this.total = pageInfo.getPages();
        this.value = pageInfo.getList();
    }
}
