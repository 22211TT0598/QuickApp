package com.example.quickapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
<<<<<<< HEAD
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnCreateExam;
    Button btnListExam;
    static List<Course> courses=new ArrayList<>();
    static int selectedButton=-1;
=======

public class MainActivity extends AppCompatActivity {
    Button btnJoin, btnHistory;
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetControl();
        SetEvent();
<<<<<<< HEAD
    }

    private void SetControl() {
        btnCreateExam = findViewById(R.id.btnCreate);
        btnListExam = findViewById(R.id.btnListQuestion);
    }

    private void SetEvent() {
        btnCreateExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCreate = new Intent(MainActivity.this, CreateExamActivity.class);
                startActivity(iCreate);
            }
        });
        btnListExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iList = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(iList);
                selectedButton=4;
=======

    }

    private void SetControl() {
        btnJoin = findViewById(R.id.btnJoin);
        btnHistory = findViewById(R.id.btnHistory);
    }

    private void SetEvent() {
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(MainActivity.this, CourseActivity.class);
                join.putExtra("Navigate", 2);
                startActivity(join);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(MainActivity.this, CourseActivity.class);
                history.putExtra("Navigate", 3);
                startActivity(history);
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
            }
        });
    }

}
