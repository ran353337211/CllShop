package com.tfswufe.entity;

public class PageBean {
    private int nowPage;
    private int total;
    private int pageCount;
    private int selectXiaBiao;
    private int pageSize = 3;

    public PageBean(int nowPage, int total, int pageCount, int selectXiaBiao, int pageSize) {
        this.nowPage = nowPage;
        this.total = total;
        this.pageCount = pageCount;
        selectXiaBiao = selectXiaBiao;
        this.pageSize = pageSize;
    }

    public PageBean() {
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        int pageCount = total%pageSize == 0?total/pageSize:(total/pageSize)+1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSelectXiaBiao() {
        int selectXiaBiao = (nowPage-1)*pageSize;
        return selectXiaBiao;
    }

    public void setSelectXiaBiao(int selectXiaBiao) {
        selectXiaBiao = selectXiaBiao;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
