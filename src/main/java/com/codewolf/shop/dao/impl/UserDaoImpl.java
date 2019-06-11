package com.codewolf.shop.dao.impl;

import com.codewolf.shop.dao.IUserDao;
import com.codewolf.shop.domain.User;
import com.codewolf.shop.util.SqlSessionUtil;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UserDaoImpl implements IUserDao {
    @Override
    public User checkLogin(Map map) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("com.codewolf.shop.mapper.UserMapper" +
                ".checkLogin",map);
    }
}
