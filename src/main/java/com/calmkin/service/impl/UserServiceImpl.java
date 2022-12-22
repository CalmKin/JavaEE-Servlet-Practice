package com.calmkin.service.impl;

import com.calmkin.mapper.UserMapper;
import com.calmkin.pojo.User;
import com.calmkin.service.UserService;
import com.calmkin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User selectAllById(int id) {
        SqlSession sqlSession =factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectAllByIdsss(id);
        sqlSession.close();
        return user;
    }
}
