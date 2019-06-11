package com.codewolf.shop.service;

import com.codewolf.shop.domain.Product;
import com.codewolf.shop.qo.PageResult;
import com.codewolf.shop.qo.ProductQueryObject;

import java.util.List;

public interface IProductService {
    void delete(Long id);
    void save(Product product);
    void update(Product product);
    Product get(Long id);
    List<Product> list(ProductQueryObject qo);
    PageResult getPageResult(ProductQueryObject qo);
}
