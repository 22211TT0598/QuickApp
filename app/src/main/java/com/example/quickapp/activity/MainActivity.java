package com.example.quickapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.quickapp.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnCreateExam;
    Button btnListExam;
    Button btnJoin, btnHistory;
    DrawerLayout drawerLayout;
    NavigationView navView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    //    static List<Course> courses = new ArrayList<>();
//    static List<History>danhsachlichsu=new ArrayList<>();
    static int selectedButton = -1;
//    List<Topic> topics = new ArrayList<>();
//
//    List<Question> questions = new ArrayList<>();
//
//    List<Answer> answers = new ArrayList<>();
//    List<Student> students = new ArrayList<>();

//    DbCourse dbCourse=new DbCourse(this, "QuickApp", null,1);
//    DbTopic dbTopic=new DbTopic(this,null,1);
//    DbQuestion dbQuestion=new DbQuestion(this,null,1);
//    DbAnswer dbAnswer=new DbAnswer(this,null,1);
//    DbStudent dbStudent=new DbStudent(this,null,1);
//    DbHistory dbHistory=new DbHistory(this,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        KhoiTao();
        setControl();
        setEvent();
    }

    private void setEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.app_name);

        actionBar.setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.baseline_menu_24);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mn_Join) {
                    Intent join = new Intent(MainActivity.this, CourseActivity.class);
                    startActivity(join);
                    selectedButton = 2;
                }
               if (item.getItemId() == R.id.mn_CreateExam) {
                    Intent join = new Intent(MainActivity.this, CreateExamActivity.class);
                    startActivity(join);
                }
                if (item.getItemId() == R.id.mn_History) {
                    Intent join = new Intent(MainActivity.this, CourseActivity.class);
                    startActivity(join);
                    selectedButton = 3;
                }

                if (item.getItemId() == R.id.mn_ListQuestion) {
                    Intent join = new Intent(MainActivity.this, CourseActivity.class);
                    startActivity(join);
                    selectedButton = 4;
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void setControl() {
        drawerLayout = findViewById(R.id.drawer);
        navView = findViewById(R.id.navView);
        toolbar=findViewById(R.id.toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //    private void KhoiTao() {
//        courses=dbCourse.getListCourse();
////        topics=dbTopic.getListTopic();
////        questions=dbQuestion.getListQuestion();
////        answers=dbAnswer.getListAnswer();
////        students=dbStudent.getListStudent();
////        danhsachlichsu=dbHistory.getListHistory();
////
////        if(danhsachlichsu.size()!=0){
////            for (History history:danhsachlichsu) {
////                for (Student student:students){
////                    if(student.getMssv().equals(history.getIdHistory())){
////                        student.getListHistory().add(history);
////                        break;
////                    }
////                }
////            }
////        }
////        if(questions.size()!=0){
////            for (Question question:questions) {
////                for (Topic topic:topics){
////                    if(topic.getIdTopic().equals(question.getIdTopic())){
////                        topic.getQuestions().add(question);
////                        break;
////                    }
////                }
////            }
////        }
////        if(topics.size()!=0){
////            for (Topic topic:topics) {
////                for (Course course:courses){
////                    if(course.getIdCourse().equals(topic.getIdCourse())){
////                        course.getTopics().add(topic);
////                        break;
////                    }
////                }
////            }
////        }
//
//
//    }

//
//    private void SetControl() {
//        btnCreateExam = findViewById(R.id.btnCreate);
//        btnListExam = findViewById(R.id.btnListQuestion);
//        btnJoin = findViewById(R.id.btnJoin);
//        btnHistory = findViewById(R.id.btnHistory);
//    }
//
//    private void SetEvent() {
//        btnCreateExam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iCreate = new Intent(MainActivity.this, CreateExamActivity.class);
//                startActivity(iCreate);
//            }
//        });
//        btnListExam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iList = new Intent(MainActivity.this, CourseActivity.class);
//                startActivity(iList);
//                selectedButton = 4;
//
//            }
//        });
//        btnJoin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent join = new Intent(MainActivity.this, CourseActivity.class);
//                startActivity(join);
//                selectedButton = 2;
//            }
//        });
//        btnHistory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent history = new Intent(MainActivity.this, CourseActivity.class);
//                startActivity(history);
//                selectedButton = 3;
//            }
//        });
//    }
}
