package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {
    private List<Question>questions;

    private String idTopic;
   private  String nameTopic;
   private String idCourse;

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
    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public Topic(String idTopic, String nameTopic, String idCourse) {
        this.idTopic = idTopic;
        this.nameTopic = nameTopic;
        this.idCourse = idCourse;
    }

    public Topic(List<Question> questions, String nameTopic) {
        this.questions = questions;
        this.nameTopic = nameTopic;
    }

    public Topic() {
    }
}
