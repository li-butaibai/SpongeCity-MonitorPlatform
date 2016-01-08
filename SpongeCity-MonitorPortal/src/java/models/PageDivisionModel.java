package models;

import java.util.List;

/**
 * Created by EriclLee on 16/1/8.
 */
public class PageDivisionModel<T> {
    private int recordCount;
    private int currentPageIndex;
    private int pageSize = 10;
    private List<T> Data;
    private int pageCount;

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }

    public int getPageCount() {
        pageCount = pageSize == 0 ? 0: (int)Math.ceil((double)recordCount/pageSize);
        return pageCount;
    }
}
