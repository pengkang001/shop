package com.codewolf.shop.service.impl;

import com.codewolf.shop.dao.ProductDao;
import com.codewolf.shop.dao.impl.ProductDaoImpl;
import com.codewolf.shop.domain.Product;
import com.codewolf.shop.qo.PageResult;
import com.codewolf.shop.qo.ProductQueryObject;
import com.codewolf.shop.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductDao dao = new ProductDaoImpl();

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public Product get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Product> list(ProductQueryObject qo) {
        return dao.list(qo);
    }

    @Override
    public PageResult getPageResult(ProductQueryObject qo) {
        Integer totalCount = dao.getTotalCount(qo);
        PageResult pageResultnew  = new PageResult(totalCount, qo.getCurrentPage(),qo.getPageSize());
        return pageResultnew;
    }
}
