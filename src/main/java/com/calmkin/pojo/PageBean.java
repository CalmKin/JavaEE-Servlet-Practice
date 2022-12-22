package com.calmkin.pojo;

import java.util.List;

public class PageBean <T>{      //因为后面可能不止做Brand类型的分页查询，所以定义为自定义泛型，传什么参数就new什么对象
    private int totalCount;
    private List<T> lis;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> lis) {
        this.totalCount = totalCount;
        this.lis = lis;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getLis() {
        return lis;
    }

    public void setLis(List<T> lis) {
        this.lis = lis;
    }
}
