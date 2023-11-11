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
import com.example.quickapp.adapter.CourseAdapter;
import com.example.quickapp.models.Course;

import java.util.ArrayList;
import java.util.List;


public class CourseActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvDSMH;
    Button btnXoa;

    static int selectedCourse = -1;
    List<Course> danhsachmonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_course);
        setControl();
        setEvent();
    }

    private void setControl() {
        lvDSMH = findViewById(R.id.lstDSMH);
        toolbar = findViewById(R.id.toolbar);
        btnXoa = findViewById(R.id.btnXoa);
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
                setContentView(R.layout.activity_list_course);
//            setContentView(R.layout.activity_list_history);
                SetControl();
                SetEvent();

            }

            private void SetControl() {
                lvDSMH = findViewById(R.id.lstDSMH);
                danhsachmonhoc = new ArrayList<>();
//        List<Topic> topics = new ArrayList<>();
//        List<Question> questions = new ArrayList<>();
//        List<Answer> answers = new ArrayList<>();
//        answers.add(new Answer("3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
//        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và nền tảng lai (hybrid)."));
//        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và đa nền tảng."));
//        questions.add(new Question("Các ứng dụng di động có thể được phân thành mấy loại? Kể tên?", answers, "3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
//        answers.add(new Answer("3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
//        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và nền tảng lai (hybrid)."));
//        answers.add(new Answer("2 loại, bao gồm nền tảng gốc (native) và đa nền tảng."));
//        questions.add(new Question("Các ứng dụng di động có thể được phân thành mấy loại? Kể tên?", answers, "3 loại, bao gồm nền tảng gốc (native), nền tảng lai (hybrid) và đa nền tảng."));
//        topics.add(new Topic(questions, "Đề 1"));
//        topics.add(new Topic(questions, "Đề 2"));
//        danhsachmonhoc.add(new Course("Lập trình di động ", topics));
//        danhsachmonhoc.add(new Course("Lập trình Ứng dụng", topics));
//        danhsachmonhoc.add(new Course("Lập trình java ", topics));


            }

            private void SetEvent() {
                CourseAdapter adapter = new CourseAdapter(danhsachmonhoc, CourseActivity.this);
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
                    }
                });
            }

        });
    }
}