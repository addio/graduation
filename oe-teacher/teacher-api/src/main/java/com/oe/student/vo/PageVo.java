package com.oe.student.vo;

import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/9
 */
public class PageVo<T> implements Vo {

    private Long current = 1L;

    private Long size = 12L;

    private Long total;

    private List<T> records;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
