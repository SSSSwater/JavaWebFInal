package com.example.basicLayout;

public class Student {
    private int id;
    private String name;
    private String classnum;
    private String school;
    private String account;
    private String password;

    public Student(){}


    public Student(int id, String name, String classnum, String school, String account, String password) {
        this.id = id;
        this.name = name;
        this.classnum = classnum;
        this.school = school;
        this.account = account;
        this.password = password;
    }

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

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
