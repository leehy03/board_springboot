package com.study.hy.board.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVo {
    public PageVo(int totalCount, int totalPage, int currentPage, List<?> contents) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.contents = contents;
    }
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private List<?> contents;
}
