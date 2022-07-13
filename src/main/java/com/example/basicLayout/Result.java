package com.example.basicLayout;

public class Result {
    private int examid;
    private String stclass;
    private int stnum;
    private String name;
    private int result;

    public Result(){}

    public Result(int examid, String stclass, int stnum, String name, int result) {
        this.examid = examid;
        this.stclass = stclass;
        this.stnum = stnum;
        this.name = name;
        this.result = result;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getStclass() {
        return stclass;
    }

    public void setStclass(String stclass) {
        this.stclass = stclass;
    }

    public int getStnum() {
        return stnum;
    }

    public void setStnum(int stnum) {
        this.stnum = stnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
