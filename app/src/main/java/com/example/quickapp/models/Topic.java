package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {
    private List<Question>questions;

   private  String nameTopic;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public Topic(List<Question> questions, String nameTopic) {
        this.questions = questions;
        this.nameTopic = nameTopic;
    }
}
