package com.example.quickapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.quickapp.R;
import com.example.quickapp.fragment.SlideQuestionFragment;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.List;

public class JoinActivity extends AppCompatActivity {
    ImageView btnQuayLai;
    int position = 0;
//    RadioButton radA, radB, radC;
    int dem = 0;
    Button btnNext, btnDone, btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_join_exam);
        SetControl();
        SetEvent();

    }

    private void SetControl() {
        btnQuayLai = findViewById(R.id.btnQuayLai);
        btnNext = findViewById(R.id.btnNext);
        btnDone = findViewById(R.id.btnDone);
        btnConfirm = findViewById(R.id.btnConfirm);
//        radA = findViewById(R.id.radA);
//        radB = findViewById(R.id.radB);
//        radC = findViewById(R.id.radC);
    }

    private void SetEvent() {
        Topic topic = (Topic) getIntent().getSerializableExtra("getTopic");
        List<Question> questions = topic.getQuestions();

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

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}