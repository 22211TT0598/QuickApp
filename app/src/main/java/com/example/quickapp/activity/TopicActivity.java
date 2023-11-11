package com.example.quickapp.activity;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
=======
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952

import com.example.quickapp.R;
import com.example.quickapp.adapter.TopicAdapter;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.List;

public class TopicActivity extends AppCompatActivity {
<<<<<<< HEAD
    Toolbar toolbar;
    List<Topic> dsTopic;
    Button btnXoa;
    ListView lstDSD;
    Course course;
    static int selectedTopic=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_topic);
        course = MainActivity.courses.get(CourseActivity.selectedCourse);
        dsTopic = course.getTopics();
=======
    List<Topic> dsTopic;
    ImageView btnBacks;
    ListView lstDSD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
        setControl();
        setEvent();
    }
    private void setControl() {
<<<<<<< HEAD
        lstDSD = findViewById(R.id.lstDSD);
        toolbar=findViewById(R.id.toolbar);
        btnXoa=findViewById(R.id.btnXoa);
    }
    private void setEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(course.getNameCourse());

        TopicAdapter adapter = new TopicAdapter(dsTopic, this);
        lstDSD.setAdapter(adapter);
        lstDSD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTopic=i;
                if (MainActivity.selectedButton == 4) {
                    Intent intent = new Intent(TopicActivity.this, ListQuestionActivity.class);
                    startActivity(intent);
                }
            }
        });

        lstDSD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                btnXoa.setVisibility(View.VISIBLE);
                return false;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsTopic.remove(selectedTopic);
                adapter.notifyDataSetChanged();
                btnXoa.setVisibility(View.GONE);
=======
        setContentView(R.layout.activity_list_topic);
        lstDSD = findViewById(R.id.lstDSD);
        Course course = (Course) getIntent().getSerializableExtra("getTopics");
        dsTopic = course.getTopics();
        TopicAdapter adapter = new TopicAdapter(dsTopic, this,getIntent());
        lstDSD.setAdapter(adapter);
        btnBacks = findViewById(R.id.btnBacks);
    }
    private void setEvent() {
        btnBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
            }
        });
    }
}