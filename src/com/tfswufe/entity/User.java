package com.tfswufe.entity;

public class User {
    private int id;
    private String name;
    private String sex;
    private int age;
    private long tel;
    private String address;
    private String role;
    private String pwd;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public User(int id, String name, String sex, int age, long tel, String address, String role, String pwd) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.role = role;
        this.pwd = pwd;
    }

    public User(int id, String name, String sex, int age, long tel, String address, String role) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.role = role;
    }

    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
