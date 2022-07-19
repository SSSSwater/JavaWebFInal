package com.example.basicLayout;

public class Exam {
    private int examId;
    private String name;
    private int paperId;
    private String examClass;
    private String startTime;
    private String endTime;
    private int finish;

    public Exam() {
    }

    public Exam(int examId, String name, int paperId, String examClass, String startTime, String endTime, int finish) {
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

    public int isFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", name='" + name + '\'' +
                ", paperId=" + paperId +
                ", examClass='" + examClass + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", finish=" + finish +
                '}';
    }

    public boolean equals(Object o) {

        //判断是不是同一对象，是则返回true。
        if (this == o) return true;

        //判断传进来的对象是否为null值，为null则返回false。
        if (o == null) return false;

        //判断两者类型是否相等，如果不等，返回false。
        if (getClass() != o.getClass()) return false;

        //到这一步，o 类型一致，也不为空，进行类型转换，然后才能比较。
        Exam p = (Exam) o;

        //此处才开始真正进行比较，return后可以&&加条件，就该类的哪些属性相等，才返回true。
        return name.equals(p.name) && examClass.equals(p.examClass);
    }


}
