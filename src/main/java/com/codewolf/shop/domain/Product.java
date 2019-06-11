package com.codewolf.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@NoArgsConstructor@AllArgsConstructor
public class Product {
    private Long id;
    private String productSn;
    private String productName;
    private BigDecimal salePrice;
    private Long dirId;
    private Integer account;
}
