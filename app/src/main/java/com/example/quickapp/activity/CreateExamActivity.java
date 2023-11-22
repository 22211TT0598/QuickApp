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
import com.example.quickapp.database.DbCourse;
import com.example.quickapp.database.DbTopic;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class CreateExamActivity extends AppCompatActivity {
    Button btnNext;
    EditText edtCourse, edtNumQuestion;
    Toolbar toolbar;

    DbCourse dbCourse=new DbCourse(this, null, null,1);
    DbTopic dbTopic=new DbTopic(this,null,null,1);

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
                Course course=new Course();
                for (Course item:dbCourse.getListCourse()) {
                    if (nameCourse.equals(item.getNameCourse()))
                    {
                        check=true;
                        course=item;
                        break;
                    }
                }
                int num=0;
                if (dbTopic.getListTopic().size() != 0) {
                    for (Topic topic : dbTopic.getListTopic()) {
                        if(topic.getIdCourse().equals(course.getIdCourse())){
                            num++;
                        }
                    }
                }
                if (check==false){
                    String name="Đề số 1";
                    Topic topic=new Topic(new ArrayList<>(),name);
                    dbCourse.addCourse(String.valueOf(dbCourse.getListCourse().size()),nameCourse);
                    dbTopic.addTopic(String.valueOf(dbTopic.getListTopic().size()),name,String.valueOf(dbCourse.getListCourse().size()-1));
                    intent.putExtra("getCourseId", String.valueOf(dbCourse.getListCourse().size()));
                }else {
                    String name="Đề số "+(num+1);
//                    Topic topic=new Topic(new ArrayList<>(),name);
                    dbTopic.addTopic(String.valueOf(dbTopic.getListTopic().size()),name,course.getIdCourse());
                    intent.putExtra("getCourseId", course.getIdCourse());
                }
                startActivity(intent);
            }
        });
    }
}