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
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListQuestionActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvQuestions;
    FloatingActionButton btnAddQuestion;

    static List<Question> questions;
    Topic topic;
    int positionFocused=-1;
    static public ShowQuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question);
        topic = MainActivity.courses.get(CourseActivity.selectedCourse).getTopics().get(TopicActivity.selectedTopic);
        questions = topic.getQuestions();
        setControl();
        setEvent();
    }

    private void setEvent() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(topic.getNameTopic());
        adapter = new ShowQuestionAdapter(this, questions);
        lvQuestions.setAdapter(adapter);

        lvQuestions.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (Question item:questions) {
                    if (item.isShowLayoutEdit==true)
                    {
                        item.isShowLayoutEdit=false;
                    }
                }
                questions.get(i).isShowLayoutEdit=true;
                adapter.notifyDataSetChanged();
                positionFocused=i;

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