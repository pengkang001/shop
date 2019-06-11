package com.codewolf.shop.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    private static SqlSessionFactory factory;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"), Resources.getResourceAsProperties("user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }
}
