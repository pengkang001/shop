package com.codewolf.shop.test;

import com.codewolf.shop.domain.Product;
import com.codewolf.shop.service.IProductService;
import com.codewolf.shop.service.impl.ProductServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductDaoTest {
    IProductService service  = new ProductServiceImpl();
    @Test
    public void delete() {
        service.delete(10L);
    }

    @Test
    public void save() {
        service.save(new Product(null,"双飞燕M101鼠标",new BigDecimal
                ("120"),1L,10));
    }

    @Test
    public void update() {
        service.update(new Product(11L,"双飞燕M101鼠标",new BigDecimal
                ("120"),1L,10));
    }

    @Test
    public void get() {
        System.out.println(service.get(11L));
    }


}