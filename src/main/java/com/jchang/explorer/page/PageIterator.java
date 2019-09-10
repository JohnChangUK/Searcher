package com.jchang.explorer.page;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PageIterator<T> {

    private int page;
    private int pageSize;
    private int totalPage;
    private long totalCount;
    private List<T> result;

    public static <T> PageIterator<T> create(int page, int pageSize, long totalCount) {
        PageIterator<T> pageIterator = new PageIterator<>();
        pageIterator.setPage(page);
        pageIterator.setPageSize(pageSize);
        pageIterator.setTotalCount(totalCount);
        pageIterator.setTotalPage((int) Math.ceil((double) totalCount / (double) pageSize));
        pageIterator.setResult(new ArrayList<>());
        return pageIterator;
    }

    public static <T> PageIterator<T> create(PageIterator iterator) {
        PageIterator<T> pageIterator = create(iterator.getPage(), iterator.getPageSize(), iterator.getTotalCount());
        pageIterator.setResult(new ArrayList<>());
        return pageIterator;
    }

    private void setPage(int page) {
        this.page = Math.max(page, 0);
    }

    private void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    private void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    private void setResult(List<T> result) {
        this.result = result;
    }

    public int getOffSet() {
        return (page - 1) * pageSize;
    }
}
