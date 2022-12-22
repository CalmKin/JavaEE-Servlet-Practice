package com.calmkin.service;

import com.calmkin.pojo.Condition;
import com.calmkin.pojo.Result;
import com.calmkin.pojo.User;
import com.calmkin.pojo.PageBean;


import java.util.List;

public interface ResultService {

//    条件分页查询
    public PageBean<Result> selectByPageAndCondition(int begin, int size, Condition condition);

//    用户个人检测记录查询
    public List<Result> selectByCondition(String cardID,String userName);

}
