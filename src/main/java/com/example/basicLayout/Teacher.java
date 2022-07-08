package com.example.basicLayout;

public class Teacher {
    private int worknum;
    private String name;
    private String school;
    private String grade;
    private String subject;
    private String classnum;
    private String account;
    private String password;

    public Teacher(){}

    public int getWorknum() {
        return worknum;
    }

    public void setWorknum(int worknum) {
        this.worknum = worknum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
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

    public Teacher(int worknum, String name, String school, String grade, String subject, String classnum, String account, String password) {
        this.worknum = worknum;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.subject = subject;
        this.classnum = classnum;
        this.account = account;
        this.password = password;


    }
}
