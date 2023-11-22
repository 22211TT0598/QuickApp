package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quickapp.R;
import com.example.quickapp.adapter.ShowQuestionAdapter;
import com.example.quickapp.database.DbAnswer;
import com.example.quickapp.database.DbQuestion;
import com.example.quickapp.models.Answer;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListQuestionActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvQuestions;
    FloatingActionButton btnAddQuestion;

    static List<Question> questions=new ArrayList<>();
    Topic topic;
    static String selectedIdQuestion = null;
    static Question selectedQuestion=new Question();
    static public ShowQuestionAdapter adapter;
    DbQuestion dbQuestion=new DbQuestion(this,null,null,1);
    DbAnswer dbAnswer=new DbAnswer(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question);
        if (dbQuestion.getListQuestion().size() != 0) {
            questions.clear();
            for (Question question : dbQuestion.getListQuestion()) {
                if(question.getIdTopic().equals(TopicActivity.selectedIdTopic)){
                    questions.add(question);
                }
            }
        }
        setControl();
        setEvent();
    }

    private void setEvent() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(TopicActivity.selectedTopic.getNameTopic());
        adapter = new ShowQuestionAdapter(this, questions);
        lvQuestions.setAdapter(adapter);

        lvQuestions.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIdQuestion = questions.get(i).getIdQuestion();
                selectedQuestion = questions.get(i);
                for (Question item:questions) {
                    if (item.isShowLayoutEdit==true)
                    {
                        item.isShowLayoutEdit=false;
                    }
                }
                questions.get(i).isShowLayoutEdit=true;
                adapter.notifyDataSetChanged();

                return false;
            }
        });

        btnAddQuestion.setOnClickListener(view -> {
                    Intent intent = new Intent(ListQuestionActivity.this, AddQuestionActivity.class);
                    intent.putExtra("getQuestionId",questions.size());
                    startActivity(intent);
                }
        );
    }
    private void setControl() {
        toolbar=findViewById(R.id.toolbar);
        lvQuestions = findViewById(R.id.lvQuestion);
        btnAddQuestion = findViewById(R.id.btnAddQuestion);
    }
}