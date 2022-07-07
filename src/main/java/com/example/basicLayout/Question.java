package com.example.basicLayout;

public class Question {
    private int id;
    private String subject;
    private String type;
    private String title;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;
    private String analysisEnabled;
    private String analysis;

    public Question(int id, String subject, String type) {
        this.id = id;
        this.subject = subject;
        this.type = type;
    }

    public Question(String subject, String type, String title, String choiceA,
                    String choiceB, String choiceC, String choiceD, String answer,
                    String analysisEnabled, String analysis) {
        this.subject = subject;
        this.type = type;
        this.title = title;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answer = answer;
        this.analysisEnabled = analysisEnabled;
        this.analysis = analysis;
    }

    public Question(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysisEnabled() {
        return analysisEnabled;
    }

    public void setAnalysisEnabled(String analysisEnabled) {
        this.analysisEnabled = analysisEnabled;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", choiceA='" + choiceA + '\'' +
                ", choiceB='" + choiceB + '\'' +
                ", choiceC='" + choiceC + '\'' +
                ", choiceD='" + choiceD + '\'' +
                ", answer='" + answer + '\'' +
                ", analysisEnabled='" + analysisEnabled + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}
