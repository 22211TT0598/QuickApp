package com.example.quickapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.History;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnCreateExam;
    Button btnListExam;
    static List<Course> courses = new ArrayList<>();
    static List<History>danhsachlichsu=new ArrayList<>();
    static int selectedButton = -1;
    Button btnJoin, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetControl();
        SetEvent();
    }

    private void SetControl() {
        btnCreateExam = findViewById(R.id.btnCreate);
        btnListExam = findViewById(R.id.btnListQuestion);
        btnJoin = findViewById(R.id.btnJoin);
        btnHistory = findViewById(R.id.btnHistory);
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
                selectedButton = 4;

            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(join);
                selectedButton = 2;
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(history);
                selectedButton = 3;
            }
        });
    }
}
