package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quickapp.R;
import com.example.quickapp.adapter.TopicAdapter;
import com.example.quickapp.database.DbCourse;
import com.example.quickapp.database.DbTopic;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnXoa;
    ListView lstDSD;
    static String selectedIdTopic = null;
    static Topic selectedTopic=new Topic();
    List<Topic>topics=new ArrayList<>();
    DbCourse dbCourse=new DbCourse(this, null, null,1);
    DbTopic dbTopic = new DbTopic(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_topic);
        if (dbTopic.getListTopic().size() != 0) {
            for (Topic topic : dbTopic.getListTopic()) {
                if(topic.getIdCourse().equals(CourseActivity.selectedIdCourse)){
                    topics.add(topic);
                }
            }
        }
        setControl();
        setEvent();
    }

    private void setControl() {
        lstDSD = findViewById(R.id.lstDSD);
        toolbar = findViewById(R.id.toolbar);
        btnXoa = findViewById(R.id.btnXoa);
    }

    private void setEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(CourseActivity.selectedCourse.getNameCourse());

        TopicAdapter adapter = new TopicAdapter(topics, this);
        lstDSD.setAdapter(adapter);
        lstDSD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIdTopic = topics.get(i).getIdTopic();
                selectedTopic = topics.get(i);
                if (MainActivity.selectedButton == 4) {
                    Intent intent = new Intent(TopicActivity.this, ListQuestionActivity.class);
                    startActivity(intent);
                }
                if (MainActivity.selectedButton == 2) {
                    Intent intent = new Intent(TopicActivity.this, JoinActivity.class);
                    startActivity(intent);
                }

                if (MainActivity.selectedButton == 3) {
                    Intent intent = new Intent(TopicActivity.this, HistoryActivity.class);
                    startActivity(intent);
                }
            }
        });

        lstDSD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIdTopic = topics.get(i).getIdTopic();
                selectedTopic = topics.get(i);
                btnXoa.setVisibility(View.VISIBLE);
                return false;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topics.remove(selectedTopic);
                adapter.notifyDataSetChanged();
                dbTopic.deleteTopic(selectedIdTopic);
                btnXoa.setVisibility(View.GONE);
                setContentView(R.layout.activity_list_topic);
                lstDSD = findViewById(R.id.lstDSD);
                Course course = (Course) getIntent().getSerializableExtra("getTopics");
                TopicAdapter adapter = new TopicAdapter(topics, TopicActivity.this);
                lstDSD.setAdapter(adapter);
            }
        });
    }
}