package com.calmkin.service;

import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Subsc;

public interface SubsService {
//    获取所有的预约记录
    public PageBean<Subsc> selectByPage(int currentPage,int pageSize);

//    新增预约记录
    public void addSubs(Subsc subsc);
}
