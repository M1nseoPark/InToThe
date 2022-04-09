package com.example.intothe.SocialScale;

public class Situation {
    private String situation;
    private String exam1;
    private String exam2;
    private int answer;
    private String photo;

    public Situation(String situation, String exam1, String exam2, int answer, String photo) {
        this.situation = situation;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.answer = answer;
        this.photo = photo;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getExam1() {
        return exam1;
    }

    public void setExam1(String exam1) {
        this.exam1 = exam1;
    }

    public String getExam2() {
        return exam2;
    }

    public void setExam2(String exam2) {
        this.exam2 = exam2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
