package com.example.quickapp.activity;

<<<<<<< HEAD
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
import com.example.quickapp.adapter.CourseAdapter;
=======
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.adapter.CourseAdapter;
import com.example.quickapp.models.Answer;
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;


public class CourseActivity extends AppCompatActivity {
<<<<<<< HEAD
    Toolbar toolbar;
    ListView lvDSMH;
    Button btnXoa;

    static int selectedCourse = -1;
=======
    List<Course> danhsachmonhoc;
    ImageView btnback;
    ListView lstDSMH;

>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_list_course);
        setControl();
        setEvent();
    }

    private void setControl() {
        lvDSMH = findViewById(R.id.lstDSMH);
        toolbar = findViewById(R.id.toolbar);
        btnXoa=findViewById(R.id.btnXoa);
    }

    private void setEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Danh sách môn học");

        CourseAdapter adapter = new CourseAdapter(MainActivity.courses, this);
        lvDSMH.setAdapter(adapter);
        lvDSMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCourse = i;
                Intent intent = new Intent(CourseActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });
        lvDSMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                btnXoa.setVisibility(View.VISIBLE);
                return false;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.courses.remove(selectedCourse);
                adapter.notifyDataSetChanged();
                btnXoa.setVisibility(View.GONE);
=======
            setContentView(R.layout.activity_list_course);
//            setContentView(R.layout.activity_list_history);
        SetControl();
        SetEvent();

    }

    private void SetControl() {
        lstDSMH = findViewById(R.id.lstDSMH);
        danhsachmonhoc = new ArrayList<>();

        List<Topic> topics = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và nền tảng lai (hybrid)."));
        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và đa nền tảng."));
        questions.add(new Question("Câu 1. Các ứng dụng di động có thể được phân thành mấy loại? Kể tên?", answers, "3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
        answers.add(new Answer("3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và nền tảng lai (hybrid)."));
        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và đa nền tảng."));
        questions.add(new Question("Câu 2. Các ứng dụng di động có thể được phân thành mấy loại? Kể tên?", answers, "3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
        topics.add(new Topic(questions, "Đề 1"));
        topics.add(new Topic(questions, "Đề 2"));
        danhsachmonhoc.add(new Course("Lập trình di động ", topics));
        danhsachmonhoc.add(new Course("Lập trình Ứng dụng", topics));
        danhsachmonhoc.add(new Course("Lập trình java ", topics));
        btnback = findViewById(R.id.btnback);
        CourseAdapter adapter = new CourseAdapter(danhsachmonhoc, this,getIntent());
        lstDSMH.setAdapter(adapter);
    }

    private void SetEvent() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
            }
        });
    }

}