package com.calmkin.service.impl;

import com.calmkin.mapper.PlaceMapper;
import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;
import com.calmkin.service.PlaceService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.logging.Logger;

public class PlaceServiceImpl implements PlaceService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//    分页查询功能
    @Override
    public PageBean<Place> selectByPage(int currPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();

        PlaceMapper mapper = sqlSession.getMapper(PlaceMapper.class);

        int begin = (currPage-1)*pageSize;
        List<Place>  lis = mapper.selectAllPlaces(begin,pageSize);

        int tot = mapper.totalCount();

        PageBean<Place> pageBean  = new PageBean<>(tot,lis);

        sqlSession.close();

        return pageBean;
    }
//    添加新的检测点
    public void addPlace(Place place)
    {
        SqlSession sqlSession = factory.openSession();

        PlaceMapper mapper  = sqlSession.getMapper(PlaceMapper.class);

        mapper.addPlace(place);

        sqlSession.commit();
        sqlSession.close();
    }
//修改单个地点的信息
    @Override
    public void changeSingle(Place place) {
        SqlSession sqlSession = factory.openSession();

        PlaceMapper mapper  = sqlSession.getMapper(PlaceMapper.class);

        mapper.updatePlace(place);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();

        PlaceMapper mapper  = sqlSession.getMapper(PlaceMapper.class);

        for (int num :ids)
        {
            System.out.println(num);
        }

        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<String> accessiblePlace() {
        SqlSession sqlSession = factory.openSession();

        PlaceMapper mapper  = sqlSession.getMapper(PlaceMapper.class);

        List<String> strings = mapper.accessiblePlace();

        sqlSession.close();

        return strings;
    }
}
