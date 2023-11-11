package com.example.quickapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;

public class MainActivity extends AppCompatActivity {
    Button btnJoin, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetControl();
        SetEvent();

    }

    private void SetControl() {
        btnJoin = findViewById(R.id.btnJoin);
        btnHistory = findViewById(R.id.btnHistory);
    }

    private void SetEvent() {
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent join = new Intent(MainActivity.this, CourseActivity.class);
                join.putExtra("Navigate", 2);
                startActivity(join);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(MainActivity.this, CourseActivity.class);
                history.putExtra("Navigate", 3);
                startActivity(history);
            }
        });
    }

}
