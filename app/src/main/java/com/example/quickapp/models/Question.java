package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String title;
    private List<String>answers;
    private String correct;

    public boolean isShowLayoutEdit=false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public Question(String title, List<String> answers, String correct) {
        this.title = title;
        this.answers = answers;
        this.correct = correct;
    }
}
