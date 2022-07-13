package com.example.basicLayout;

public class Paper {
    private int Id;
    private String subject;
    private int mark;
    private String titNum;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTitNum() {
        return titNum;
    }

    public void setTitNum(String titNum) {
        this.titNum = titNum;
    }

}
