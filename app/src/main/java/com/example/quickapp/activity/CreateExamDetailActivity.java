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
import com.example.quickapp.fragment.NewQuestionFragment;

public class CreateExamDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnNext,btnFinish;
    NewQuestionFragment fragment;
    int numQuestion;
    int courseId;
    int index=0;
    FragmentManager manager;
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
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(MainActivity.courses.get(courseId).getNameCourse());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<numQuestion){
                    addOnListQuestion();
                    transitionFragment();
                }
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOnListQuestion();
                Intent intent=new Intent(CreateExamDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initial() {
        transitionFragment();
    }

    private void addOnListQuestion(){
        int topicId=MainActivity.courses.get(courseId).getTopics().size()-1;
        MainActivity.courses.get(courseId).getTopics().get(topicId).getQuestions().add(fragment.getQuestionFromFragment());
    }

    private void transitionFragment(){
        fragment=new NewQuestionFragment(this,index);
        manager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        if (index==numQuestion-1){
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        }
        index++;
    }
}