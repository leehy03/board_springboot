package com.study.hy.board.util;

public class PageUtil {

    public static int getOffset(int currentPage, int pageSize) {
        return pageSize * (currentPage - 1);
    }
}
