package com.example.intothe.model;

public class TestItem {

    private int testId;
    private String question;
    private String type;
    private String answer;

    public TestItem(int testId, String question, String type, String answer) {
        this.testId = testId;
        this.question = question;
        this.type = type;
        this.answer = answer;
    }

    public int getTestId() {
        return testId;
    }

    public String getQuestion() {
        return question;
    }

    public String isType() {
        return type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
