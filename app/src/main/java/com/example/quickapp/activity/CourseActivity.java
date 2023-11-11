package com.example.quickapp.activity;

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
import com.example.quickapp.models.Course;
import com.example.quickapp.models.Question;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;


public class CourseActivity extends AppCompatActivity {
    List<Course> danhsachmonhoc;
    ImageView btnback;
    ListView lstDSMH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            }
        });
    }

}