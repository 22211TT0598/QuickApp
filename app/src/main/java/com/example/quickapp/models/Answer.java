package com.example.quickapp.models;

import java.io.Serializable;

public class Answer implements Serializable {
    private  String idAnswer;
    private String text;

    private  String idQuestion;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(String idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Answer(String text) {
        this.text = text;
    }


    public Answer(String idAnswer, String text, String idQuestion) {
        this.idAnswer = idAnswer;
        this.text = text;
        this.idQuestion = idQuestion;
    }

    public Answer() {
    }
}
