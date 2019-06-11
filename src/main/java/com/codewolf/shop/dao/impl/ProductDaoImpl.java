package com.codewolf.shop.dao.impl;

import com.codewolf.shop.dao.ProductDao;
import com.codewolf.shop.domain.Product;
import com.codewolf.shop.qo.ProductQueryObject;
import com.codewolf.shop.util.SqlSessionUtil;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void delete(Long id) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.delete("com.codewolf.shop.mapper.ProductMapper.delete", id);
        sqlSession.commit();
    }

    @Override
    public void save(Product product) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("com.codewolf.shop.mapper.ProductMapper.insert", product);
        sqlSession.commit();
    }

    @Override
    public void update(Product product) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.update("com.codewolf.shop.mapper.ProductMapper.update", product);
        sqlSession.commit();
    }

    @Override
    public Product get(Long id) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Product product = sqlSession.selectOne("com.codewolf.shop.mapper.ProductMapper.get", id);
        return product;
    }

    @Override
    public List<Product> list(ProductQueryObject qo) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Product> list = sqlSession.selectList("com.codewolf.shop.mapper" +
                ".ProductMapper.list",qo);
        return list;
    }

    @Override
    public Integer getTotalCount(ProductQueryObject qo) {
        @Cleanup
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
       Integer totalCount = sqlSession.selectOne("com.codewolf.shop.mapper" +
                ".ProductMapper.count",qo);
        return totalCount;
    }
}
