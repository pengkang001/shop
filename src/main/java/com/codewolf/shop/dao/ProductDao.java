package com.codewolf.shop.dao;

import com.codewolf.shop.domain.Product;
import com.codewolf.shop.qo.ProductQueryObject;

import java.util.List;

public interface ProductDao {
    void delete(Long id);

    void save(Product product);

    void update(Product product);

    Product get(Long id);

    List<Product> list(ProductQueryObject qo);

    Integer getTotalCount(ProductQueryObject qo);
}
