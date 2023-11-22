package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String idQuestion;
    private String title;
    private String correct;

    private  String idTopic;

    public boolean isShowLayoutEdit=false;

    public String getTitle() {
        return title;
    }

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCorrect () {
            return correct;
        }
        public void setCorrect (String correct){
            this.correct = correct;
        }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }


    public Question(String idQuestion, String title, String correct, String idCourse) {
        this.idQuestion = idQuestion;
        this.title = title;
        this.correct = correct;
        this.idTopic = idCourse;
    }

    public Question() {
    }
}
