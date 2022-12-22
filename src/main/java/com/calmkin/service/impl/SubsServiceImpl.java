package com.calmkin.service.impl;

import com.calmkin.mapper.PlaceMapper;
import com.calmkin.mapper.ResultMapper;
import com.calmkin.mapper.SubsMapper;
import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.*;
import com.calmkin.service.SubsService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Random;

public class SubsServiceImpl implements SubsService {

    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

//    分页查询服务
    @Override
    public PageBean<Subsc> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();

        SubsMapper mapper = sqlSession.getMapper(SubsMapper.class);

        int offset = (currentPage-1)*pageSize;

        List<Subsc> lis = mapper.selectAllSubs(offset,pageSize);

        int tot = mapper.selectTotalCount();

        PageBean<Subsc> pageBean = new PageBean<>(tot,lis);

        sqlSession.close();

        return pageBean;
    }
//    添加预约记录服务,同时根据预约记录添加检测结果记录
    @Override
    public void addSubs(Subsc subsc) {
        SqlSession sqlSession = factory.openSession();

        SubsMapper subsMapper = sqlSession.getMapper(SubsMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PlaceMapper placeMapper =sqlSession.getMapper(PlaceMapper.class);
        ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);

        String userCardId = subsc.getCardID();

        Integer userId = userMapper.getUserId(userCardId);
//        先判断是否存在用户
//        如果不存在，那就抽取用户bean，进行插入用户操作
        if( userId == null )
        {
            userMapper.insertUser(subsc);
            userId =  userMapper.getUserId(userCardId);
        }
//      插入预约记录
        subsMapper.addSubscription(subsc);



        /*生成随机结果*/
        String[] randomResult = {"阴性","阴性","阴性","阳性","阳性","阴性","阴性","阴性","阴性","阳性"};
        Random random = new Random();
        int pick = random.nextInt(10);
        Result result = new Result();
        result.setUserName(subsc.getUserName());
        result.setPlace(subsc.getSubPlace());
        result.setCheckTime(subsc.getSubTime());
        result.setUserId(userId);
        result.setAffected(randomResult[pick]);


        //      更新检测点的预约情况,人数加一
        placeMapper.updateNumOfSubs(subsc.getSubPlace());
//        同时插入一条新的检测结果
        resultMapper.insertResult(result);

        sqlSession.commit();

        sqlSession.close();

    }


}
