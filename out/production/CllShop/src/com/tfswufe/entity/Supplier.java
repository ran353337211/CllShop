package com.tfswufe.entity;

public class Supplier {
    private int id;
    private String supname;
    private String supnotice;
    private String name;
    private Long suptel;
    private String supaddress;
    private String supemail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSupnotice() {
        return supnotice;
    }

    public void setSupnotice(String supnotice) {
        this.supnotice = supnotice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSuptel() {
        return suptel;
    }

    public void setSuptel(Long suptel) {
        this.suptel = suptel;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public void setSupaddress(String supaddress) {
        this.supaddress = supaddress;
    }

    public String getSupemail() {
        return supemail;
    }

    public void setSupemail(String supemail) {
        this.supemail = supemail;
    }

    public Supplier() {
    }

    public Supplier(int id, String supname, String supnotice, String name, Long suptel, String supaddress, String supemail) {
        this.id = id;
        this.supname = supname;
        this.supnotice = supnotice;
        this.name = name;
        this.suptel = suptel;
        this.supaddress = supaddress;
        this.supemail = supemail;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supname='" + supname + '\'' +
                ", supnotice='" + supnotice + '\'' +
                ", name='" + name + '\'' +
                ", suptel=" + suptel +
                ", supaddress='" + supaddress + '\'' +
                ", supemail='" + supemail + '\'' +
                '}';
    }
}
