package com.tfswufe.entity;

public class Bill {
    private int id;
    private String name;
    private int number;
    private Double money;
    private String paymoney;
    private String supname;
    private String notice;
    private String date;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bill() {
    }

    public Bill(int id, String name, int number, Double money, String paymoney, String supname, String notice, String date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.money = money;
        this.paymoney = paymoney;
        this.supname = supname;
        this.notice = notice;
        this.date = date;
    }
}
