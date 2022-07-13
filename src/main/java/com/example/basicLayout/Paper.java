package com.example.basicLayout;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Paper {
    private int paperid;
    private String subject;
    private String titlenum;
    private String exammark;

    public Paper(){}

    public Paper(int paperid, String subject, String titlenum, String exammark) {
        this.paperid = paperid;
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
}
