package com.example.quickapp.models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String title;
<<<<<<< HEAD
    private List<String>answers;
    private String correct;

    public boolean isShowLayoutEdit=false;

=======
    private List<Answer>answers;
    private String correct;

>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

<<<<<<< HEAD
    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
=======
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
        this.answers = answers;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

<<<<<<< HEAD
    public Question(String title, List<String> answers, String correct) {
=======
    public Question(String title, List<Answer> answers, String correct) {
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
        this.title = title;
        this.answers = answers;
        this.correct = correct;
    }
}
