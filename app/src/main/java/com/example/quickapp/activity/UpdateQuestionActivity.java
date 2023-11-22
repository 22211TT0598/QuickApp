package com.example.quickapp.activity;

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

import com.example.quickapp.R;
import com.example.quickapp.database.DbAnswer;
import com.example.quickapp.database.DbQuestion;
import com.example.quickapp.models.Answer;
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
    int index;
    DbQuestion dbQuestion=new DbQuestion(this,null,null,1);
    DbAnswer dbAnswer=new DbAnswer(this,null,null,1);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_a_question);
        index=getIntent().getIntExtra("getQuestionId",-1);
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
                updateQuestion();
                ListQuestionActivity.adapter.notifyDataSetChanged();
                onBackPressed();
            }
        });
    }

    private void updateQuestion() {
        List<String>answers=new ArrayList<>();
        answers.add(edtA.getText().toString());
        answers.add(edtB.getText().toString());
        answers.add(edtC.getText().toString());

        Question newQuestion=new Question(ListQuestionActivity.selectedIdQuestion,edtQuestion.getText().toString(),getContentCorrect(answers),CourseActivity.selectedIdCourse);
        dbQuestion.updateQuestion(newQuestion.getIdQuestion(), newQuestion.getTitle(), newQuestion.getCorrect());
        ListQuestionActivity.questions.get(index).setTitle(newQuestion.getTitle());
        ListQuestionActivity.questions.get(index).setCorrect(newQuestion.getCorrect());

        updateAnswers();
    }

    private void updateAnswers() {
        List<Answer>answers=new ArrayList<>();
        for(Answer answer:dbAnswer.getListAnswer()){
            if(answer.getIdQuestion().equals(ListQuestionActivity.selectedIdQuestion)){
                answers.add(answer);
            }
        }

        dbAnswer.updateAnswer(answers.get(0).getIdAnswer(),edtA.getText().toString());
        dbAnswer.updateAnswer(answers.get(1).getIdAnswer(),edtB.getText().toString());
        dbAnswer.updateAnswer(answers.get(2).getIdAnswer(),edtC.getText().toString());
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
        Question question=new Question();
        for (Question item:dbQuestion.getListQuestion()) {
            if(item.getIdQuestion().equals(ListQuestionActivity.selectedIdQuestion)){
                question=item;
                break;
            }
        }

        tvTitle.setText("Câu "+(index+1));
        edtQuestion.setText(question.getTitle());
        List<Answer>answers=new ArrayList<>();
        DbAnswer dbAnswer=new DbAnswer(this,null,null,1);
        for (Answer item:dbAnswer.getListAnswer()) {
            if(item.getIdQuestion().equals(ListQuestionActivity.selectedIdQuestion)){
                answers.add(item);
            }
        }
        edtA.setText(answers.get(0).getText());
        edtB.setText(answers.get(1).getText());
        edtC.setText(answers.get(2).getText());
        getDataSpinner();
        if (question.getCorrect().equals(edtA.getText().toString())){
            spnCorrect.setSelection(0);
        }
        else if (question.getCorrect().equals(edtB.getText().toString())){
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
