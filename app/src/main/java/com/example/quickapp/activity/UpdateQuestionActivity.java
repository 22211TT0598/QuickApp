package com.example.quickapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.quickapp.R;
import com.example.quickapp.fragment.NewQuestionFragment;
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class UpdateQuestionActivity extends AppCompatActivity implements View.OnFocusChangeListener{
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        actionBar.setTitle("Update Question");
        setDataIntoViews();
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
                List<String>answers=new ArrayList<>();
                answers.add(edtA.getText().toString());
                answers.add(edtB.getText().toString());
                answers.add(edtC.getText().toString());
                Question question1=new Question(edtQuestion.getText().toString(),answers,getContentCorrect(answers));
                ListQuestionActivity.questions.set(questionId,question1);
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

    private void setDataIntoViews(){
        tvTitle.setText("Câu "+(questionId+1));
        edtQuestion.setText(ListQuestionActivity.questions.get(questionId).getTitle());
        edtA.setText(ListQuestionActivity.questions.get(questionId).getAnswers().get(0));
        edtB.setText(ListQuestionActivity.questions.get(questionId).getAnswers().get(1));
        edtC.setText(ListQuestionActivity.questions.get(questionId).getAnswers().get(2));
        getDataSpinner();
        if (ListQuestionActivity.questions.get(questionId).getCorrect().equals(edtA.getText().toString())){
            spnCorrect.setSelection(0);
        }
        else if (ListQuestionActivity.questions.get(questionId).getCorrect().equals(edtB.getText().toString())){
            spnCorrect.setSelection(1);
        }
        else {
            spnCorrect.setSelection(2);
        }

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
