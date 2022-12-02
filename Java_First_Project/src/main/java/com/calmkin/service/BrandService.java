package com.calmkin.service;

import com.calmkin.mapper.BrandMapper;
import com.calmkin.pojo.Brand;
import com.calmkin.pojo.PageBean;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface BrandService {

    /*选择所有*/
    public List<Brand> selectAll();
    /*添加功能*/
    public void add(Brand brand);
    /**
     * 根据id查询
     * @return
     */
    public  void deleteByIds(int ids[]);

    public PageBean<Brand> selectByPage(int begin, int pageSize);

    public PageBean<Brand> selectByPageAndCondition(int begin,int size,Brand brand);

    /*需要获取前端返回的id*/
    public void updateSingle(Brand brand);
}
