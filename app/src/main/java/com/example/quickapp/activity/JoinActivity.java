package com.example.quickapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import  android.os.SystemClock;

import com.example.quickapp.R;
import com.example.quickapp.fragment.SlideQuestionFragment;
import com.example.quickapp.models.History;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.List;

public class JoinActivity extends AppCompatActivity {
    Toolbar toolbar;
    int position = 0;
    int dem = 0;
    static long dateStart;
    Button btnNext, btnDone, btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_join_exam);
        SetControl();
        SetEvent();

        dateStart=SystemClock.elapsedRealtime()/1000;
//            String Date=String.valueOf(date);
    }

    private void SetControl() {
        btnNext = findViewById(R.id.btnNext);
        btnDone = findViewById(R.id.btnDone);
        btnConfirm = findViewById(R.id.btnConfirm);
        toolbar=findViewById(R.id.toolbar);
    }

    private void SetEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(MainActivity.courses.get(CourseActivity.selectedCourse).getNameCourse());

        List<Question> questions = MainActivity.courses.get(CourseActivity.selectedCourse).getTopics().get(TopicActivity.selectedTopic).getQuestions();

        SlideQuestionFragment fragment = new SlideQuestionFragment(questions.get(position), JoinActivity.this);
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.frLayout_question, fragment).commit();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((RadioButton)findViewById(R.id.radA)).isChecked()) {
                    if (((RadioButton)findViewById(R.id.radA)).getText().equals(questions.get(position).getCorrect())) {
                        ((RadioButton)findViewById(R.id.radA)).setTextColor(Color.parseColor("#FF4CAF50"));
                        dem++;
                    } else {
                        ((RadioButton)findViewById(R.id.radA)).setTextColor(Color.parseColor("#DF1919"));
                    }

                }
                if (((RadioButton)findViewById(R.id.radB)).isChecked()) {
                    if (((RadioButton)findViewById(R.id.radB)).getText().equals(questions.get(position).getCorrect())) {
                        ((RadioButton)findViewById(R.id.radB)).setTextColor(Color.parseColor("#FF4CAF50"));
                        dem++;
                    } else {
                        ((RadioButton)findViewById(R.id.radB)).setTextColor(Color.parseColor("#DF1919"));
                    }

                }
                if (((RadioButton)findViewById(R.id.radC)).isChecked()) {
                    if (((RadioButton)findViewById(R.id.radC)).getText().equals(questions.get(position).getCorrect())) {
                        ((RadioButton)findViewById(R.id.radC)).setTextColor(Color.parseColor("#FF4CAF50"));
                        dem++;
                    } else {
                        ((RadioButton)findViewById(R.id.radC)).setTextColor(Color.parseColor("#DF1919"));
                    }

                }
                if (position != questions.size()) {
                    btnNext.setVisibility(View.VISIBLE);
                    btnConfirm.setVisibility(View.GONE);
                } else {
                    btnDone.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                }

            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(JoinActivity.this, ResultActivity.class);
               itn.putExtra("getResult",dem);
               itn.putExtra("getTotalQuestion",questions.size());
               startActivity(itn);

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = position + 1;
                if (position < questions.size()) {
                    btnNext.setVisibility(View.GONE);
                    btnConfirm.setVisibility(View.VISIBLE);
                    SlideQuestionFragment fragment = new SlideQuestionFragment(questions.get(position), JoinActivity.this);
                    FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
                    fragmentManager.replace(R.id.frLayout_question, fragment).commit();
                } else {
                    btnNext.setVisibility(View.GONE);
                    btnDone.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}