package com.example.quickapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.adapter.TopicAdapter;
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Topic;

import java.util.List;

public class TopicActivity extends AppCompatActivity {
    List<Topic> dsTopic;
    ImageView btnBacks;
    ListView lstDSD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setControl();
        setEvent();
    }
    private void setControl() {
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
            }
        });
    }
}