package com.calmkin.service.impl;

import com.calmkin.mapper.BrandMapper;
import com.calmkin.pojo.Brand;
import com.calmkin.pojo.PageBean;
import com.calmkin.service.BrandService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import com.google.protobuf.Service;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.logging.Logger;

//这个类相当于一个池子，集成了service接口的所有方法


public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int begin, int pageSize) {

        SqlSession sqlSession = factory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByPage(begin, pageSize);

        int totalCount=brandMapper.totalCount();    //获取总的条目数

        //封装pageBean对象
        PageBean<Brand> pageBean= new PageBean<>(totalCount,brands);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int begin, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        /*因为like里面需要的是 %str%的形式，这里需要手动添加*/
        String companyName = brand.getCompanyName();
        if(companyName!=null &&companyName.length()>0 )
        brand.setCompanyName("%"+companyName+"%");

        String brandName = brand.getBrandName();
        if(brandName!=null &&brandName.length()>0 )
            brand.setBrandName("%"+brandName+"%");

        List<Brand> brands = brandMapper.selectByPageAndCondition(begin,pageSize,brand);

        System.out.println(brands);

        int totalCount=brandMapper.totalCountByCondition(brand);    //获取总的条目数

        System.out.println(totalCount);

        PageBean<Brand> pageBean = new PageBean<>(totalCount,brands);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public void updateSingle(Brand brand) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.changeSingle(brand);
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
