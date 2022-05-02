package com.example.intothe.Test;

public class TestItem {

    private int testId;
    private String question;
    private String type;

    public TestItem(int testId, String question, String type) {
        this.testId = testId;
        this.question = question;
        this.type = type;
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
}
