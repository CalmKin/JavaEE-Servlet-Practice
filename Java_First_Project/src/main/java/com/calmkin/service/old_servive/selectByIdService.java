package com.calmkin.service.old_servive;

import com.calmkin.mapper.BrandMapper;
import com.calmkin.pojo.Brand;
import com.calmkin.service.BrandService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class selectByIdService  {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Brand selectById(int id)
    {
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }
}
