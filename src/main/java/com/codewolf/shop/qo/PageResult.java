package com.codewolf.shop.qo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {

    private Integer totalCount;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer prevPage;
    private Integer nextPage;

    public PageResult(Integer totalCount, Integer currentPage, Integer pageSize) {
        if (totalCount == 0){
            this.currentPage = 1;
            this.pageSize = pageSize;
            this.totalPage = 1;
            prevPage = 1;
            nextPage = 1;
            return;
        }

        this.totalCount = totalCount;
        this.pageSize = pageSize;
        totalPage = totalCount % pageSize == 0 ? totalCount/ pageSize :totalCount/ pageSize +1;
        this.currentPage = currentPage > totalPage ? totalPage : currentPage;
        prevPage = currentPage - 1 < 1 ? 1 : currentPage -1;
        nextPage = currentPage + 1 > totalPage ? totalPage : currentPage +1;
    }
}
