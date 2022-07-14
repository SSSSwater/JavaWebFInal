package com.example.basicLayout;

public class Exam {
    private int examId;
    private String name;
    private int paperId;
    private String examClass;
    private String startTime;
    private String endTime;
    private boolean finish;

    public Exam(int examId, String name, int paperId, String examClass, String startTime, String endTime, boolean finish) {
        this.examId = examId;
        this.name = name;
        this.paperId = paperId;
        this.examClass = examClass;
        this.startTime = startTime;
        this.endTime = endTime;
        this.finish = finish;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
