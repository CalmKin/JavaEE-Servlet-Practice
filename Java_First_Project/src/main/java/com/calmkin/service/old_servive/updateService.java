package com.calmkin.service.old_servive;

import com.calmkin.mapper.BrandMapper;
import com.calmkin.pojo.Brand;
import com.calmkin.service.BrandService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class updateService  {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public void update(Brand brand)
    {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
}
