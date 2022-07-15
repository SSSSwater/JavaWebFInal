package com.example.basicLayout;


public class Paper {
    private int paperid;
    private String papername;
    private String subject;
    private String titlenum;
    private String exammark;

    public Paper(){}

    public Paper(int paperid, String papername, String subject, String titlenum, String exammark) {
        this.paperid = paperid;
        this.papername = papername;
        this.subject = subject;
        this.titlenum = titlenum;
        this.exammark = exammark;
    }

    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitlenum() {
        return titlenum;
    }

    public void setTitlenum(String titlenum) {
        this.titlenum = titlenum;
    }

    public String getExammark() {
        return exammark;
    }

    public void setExammark(String exammark) {
        this.exammark = exammark;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperid=" + paperid +
                ", papername='" + papername + '\'' +
                ", subject='" + subject + '\'' +
                ", titlenum='" + titlenum + '\'' +
                ", exammark='" + exammark + '\'' +
                '}';
    }
}
