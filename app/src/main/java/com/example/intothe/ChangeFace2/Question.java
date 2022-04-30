package com.example.intothe.ChangeFace2;

public class Question {
    private String url;
    private String answer;

    public Question(String url, String answer) {
        this.url = url;
        this.answer = answer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
