package com.example.quickapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
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
            }
        });
    }

}
