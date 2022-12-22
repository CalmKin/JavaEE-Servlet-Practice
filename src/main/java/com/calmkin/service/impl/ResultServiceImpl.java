package com.calmkin.service.impl;

import com.calmkin.mapper.ResultMapper;
import com.calmkin.pojo.*;
import com.calmkin.pojo.Result;
import com.calmkin.service.ResultService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.logging.Logger;

//这个类相当于一个池子，集成了service接口的所有方法


public class ResultServiceImpl implements ResultService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//    分页条件查询
    @Override
    public PageBean<Result> selectByPageAndCondition(int begin, int pageSize, Condition condition) {
        SqlSession sqlSession = factory.openSession();
        ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);

        /*因为like里面需要的是 %str%的形式，这里需要手动添加*/
        String userName = condition.getUserName();
        if(userName!=null &&userName.length()>0 )
        {
            condition.setUserName("%"+userName+"%");
        }
        List<Result> conditions = resultMapper.selectByPageAndCondition(begin,pageSize,condition);

        int totalCount= resultMapper.totalCountByCondition(condition);    //获取总的条目数

        System.out.println(totalCount);

        PageBean<Result> pageBean = new PageBean<>(totalCount,conditions);

        sqlSession.close();

        return pageBean;
    }
//     用户个人检测记录查询
    @Override
    public List<Result> selectByCondition(String cardID,String userName) {

        SqlSession sqlSession = factory.openSession();

        ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);

        List<Result> results = resultMapper.selectByCondition(cardID,userName);
        sqlSession.close();

        return results;

    }

}
