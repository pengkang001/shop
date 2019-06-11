package com.codewolf.shop.qo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductQueryObject  extends QueryObject{
    private String key;
    private BigDecimal min;
    private BigDecimal max;
    private Boolean isEmpty;
    private Long dirId;
}
