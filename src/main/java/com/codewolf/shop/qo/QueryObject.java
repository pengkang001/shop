package com.codewolf.shop.qo;

import lombok.Data;

@Data
public class QueryObject {
    private Integer currentPage = 1;
    private Integer pageSize = 3;

    public Integer getStart() {
        return (currentPage - 1) * pageSize;
    }

}
