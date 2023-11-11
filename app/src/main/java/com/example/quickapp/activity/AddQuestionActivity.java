package com.example.quickapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.quickapp.R;
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    Toolbar toolbar;
    LinearLayout layoutScreen;
    TextView tvTitle;
    EditText edtQuestion;
    EditText edtA;
    EditText edtB;
    EditText edtC;
    Spinner spnCorrect;
    Button btnFinish;
    int questionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_a_question);
        questionId=getIntent().getIntExtra("getQuestionId",-1);
        setControl();
        setEvent();
    }

    private void setEvent() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Question");
        tvTitle.setText("Câu "+(questionId+1));
        layoutScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentFocus().clearFocus();
            }
        });
        edtA.setOnFocusChangeListener(this);
        edtB.setOnFocusChangeListener(this);
        edtC.setOnFocusChangeListener(this);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contentQuestion = edtQuestion.getText().toString().trim();
                List<String> answers=new ArrayList<>();
                answers.add(edtA.getText().toString());
                answers.add(edtB.getText().toString());
                answers.add(edtC.getText().toString());
                Question question=new Question(contentQuestion,answers,getContentCorrect(answers));
                ListQuestionActivity.questions.add(question);
                ListQuestionActivity.adapter.notifyDataSetChanged();
                onBackPressed();
            }
        });
    }

    private void setControl() {
        toolbar=findViewById(R.id.toolbar);
        layoutScreen=findViewById(R.id.layoutScreen);
        tvTitle=findViewById(R.id.tvTitle);
        edtQuestion = findViewById(R.id.edtQuestion);
        edtA = findViewById(R.id.edtDapAnA);
        edtB = findViewById(R.id.edtDapAnB);
        edtC = findViewById(R.id.edtDapAnC);
        spnCorrect = findViewById(R.id.spinnerCorrect);
        btnFinish=findViewById(R.id.btnFinish);
    }

    private void getDataSpinner() {
        String answerA = edtA.getText().toString().trim();
        String answerB = edtB.getText().toString().trim();
        String answerC = edtC.getText().toString().trim();
        ArrayList<String> arrayList = new ArrayList<>();
        if ((!answerA.isEmpty()) && (!answerB.isEmpty()) && (!answerC.isEmpty())) {
            arrayList.add("Đáp án A");
            arrayList.add("Đáp án B");
            arrayList.add("Đáp án C");
        }
        //Set data for spinner
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayList);
        spnCorrect.setAdapter(adapter);
    }
    private String getContentCorrect(List<String>answers) {
        if (spnCorrect.getSelectedItem().equals("Đáp án A")){
            return answers.get(0);
        }
        if (spnCorrect.getSelectedItem().equals("Đáp án B")){
            return answers.get(1);
        }
        if (spnCorrect.getSelectedItem().equals("Đáp án C")){
            return answers.get(2);
        }
        return "";
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        getDataSpinner();
    }
}
