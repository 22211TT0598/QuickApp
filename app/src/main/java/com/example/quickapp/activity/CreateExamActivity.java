package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quickapp.R;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class CreateExamActivity extends AppCompatActivity {
    Button btnNext;
    EditText edtCourse, edtNumQuestion;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnNext = findViewById(R.id.btnNext);
        edtCourse = findViewById(R.id.edtCourse);
        edtNumQuestion = findViewById(R.id.edtNumberQuestion);
        toolbar = findViewById(R.id.toolbar);

    }

    private void setEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        edtNumQuestion.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String nameCourse = edtCourse.getText().toString().trim();
                int numQuestion = (textView.getText().toString()).isEmpty() ? 0 : Integer.parseInt(edtNumQuestion.getText().toString());
                if (i==EditorInfo.IME_ACTION_DONE){
                    textView.clearFocus();
                    if ((!nameCourse.isEmpty())&&numQuestion>0){
                        btnNext.setEnabled(true);
                    }
                }
                return false;
            }
        });
        edtCourse.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String nameCourse = textView.getText().toString().trim();
                int numQuestion = (edtNumQuestion.getText().toString()).isEmpty() ? 0 : Integer.parseInt(edtNumQuestion.getText().toString());
                if (i==EditorInfo.IME_ACTION_NEXT){
                    if ((!nameCourse.isEmpty())&&numQuestion>0){
                        btnNext.setEnabled(true);
                    }
                }
                return false;
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameCourse = edtCourse.getText().toString().trim();
                int numQuestion = (edtNumQuestion.getText().toString()).isEmpty() ? 0 : Integer.parseInt(edtNumQuestion.getText().toString());
                Intent intent = new Intent(CreateExamActivity.this, CreateExamDetailActivity.class);

                intent.putExtra("getNumQuestion", numQuestion);

                boolean check=false;
                int i=0;
                for (Course item:MainActivity.courses) {
                    if (nameCourse.equals(item.getNameCourse()))
                    {
                        check=true;
                        String name="Đề số"+(item.getTopics().size()+1);
                        Topic topic=new Topic(new ArrayList<>(),name);
                        item.getTopics().add(topic);
                        intent.putExtra("getCourseId", i);
                        break;
                    }
                    i++;
                }
                if (check==false){
                    String name="Đề số 1";
                    Topic topic=new Topic(new ArrayList<>(),name);
                    List<Topic>topics=new ArrayList<>();
                    topics.add(topic);
                    MainActivity.courses.add(new Course(nameCourse,topics));
                    intent.putExtra("getCourseId", MainActivity.courses.size()-1);
                }
                startActivity(intent);
            }
        });
    }
}