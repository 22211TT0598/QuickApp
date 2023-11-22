package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.quickapp.R;
import com.example.quickapp.database.DbAnswer;
import com.example.quickapp.database.DbCourse;
import com.example.quickapp.database.DbQuestion;
import com.example.quickapp.database.DbTopic;
import com.example.quickapp.fragment.NewQuestionFragment;
import com.example.quickapp.models.Answer;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class CreateExamDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnNext,btnFinish;
    NewQuestionFragment fragment;
    int numQuestion;
    int courseId;
    int index=0;
    FragmentManager manager;
    DbCourse dbCourse=new DbCourse(this, null, null,1);
    DbTopic dbTopic=new DbTopic(this,null,null,1);
    DbQuestion dbQuestion=new DbQuestion(this,null,null,1);
    DbAnswer dbAnswer=new DbAnswer(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_detail);
        courseId=getIntent().getIntExtra("getCourseId",-1);
        numQuestion=getIntent().getIntExtra("getNumQuestion",0);
        manager=getSupportFragmentManager();
        setControl();
        initial();
        setEvent();
    }

    private void setControl() {
        toolbar=findViewById(R.id.toolbar);
        btnNext=findViewById(R.id.btnNext);
        btnFinish=findViewById(R.id.btnFinish);
    }

    private void setEvent() {
        String nameCourse="";
        for(Course item:dbCourse.getListCourse()){
            if(item.getIdCourse().equals(String.valueOf(courseId))){
                nameCourse=item.getNameCourse();
                break;
            }
        }
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(nameCourse);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<numQuestion){
                    addAQuestion();
                    transitionFragment();
                }
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAQuestion();
                Intent intent=new Intent(CreateExamDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void addAQuestion() {
        String contentQuestion = fragment.edtQuestion.getText().toString().trim();
        List<Answer> answers=new ArrayList<>();

        dbAnswer.addAnswer(String.valueOf(dbAnswer.getListAnswer().size()),fragment.edtA.getText().toString(),String.valueOf(dbQuestion.getListQuestion().size()));
        dbAnswer.addAnswer(String.valueOf(dbAnswer.getListAnswer().size()),fragment.edtB.getText().toString(),String.valueOf(dbQuestion.getListQuestion().size()));
        dbAnswer.addAnswer(String.valueOf(dbAnswer.getListAnswer().size()),fragment.edtC.getText().toString(),String.valueOf(dbQuestion.getListQuestion().size()));
        for(Answer item:dbAnswer.getListAnswer()){
            if(item.getIdQuestion().equals(String.valueOf(dbQuestion.getListQuestion().size()))){
                answers.add(item);
            }
        }
        dbQuestion.addQuestion(String.valueOf(dbQuestion.getListQuestion().size()),contentQuestion,getContentCorrect(answers),String.valueOf(dbTopic.getListTopic().size()-1));
    }

    private String getContentCorrect(List<Answer >answers) {
        if (fragment.spnCorrect.getSelectedItem().equals("Đáp án A")){
            return answers.get(0).getText();
        }
        if (fragment.spnCorrect.getSelectedItem().equals("Đáp án B")){
            return answers.get(1).getText();
        }
        if (fragment.spnCorrect.getSelectedItem().equals("Đáp án C")){
            return answers.get(2).getText();
        }
        return "";
    }

    private void initial() {
        transitionFragment();
    }

    private void transitionFragment(){
        fragment=new NewQuestionFragment(this,index,String.valueOf((dbTopic.getListTopic().size())-1));
        manager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        if (index==numQuestion-1){
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        }
        index++;
    }
}