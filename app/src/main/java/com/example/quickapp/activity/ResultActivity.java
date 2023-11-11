package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;

public class ResultActivity extends AppCompatActivity {
    ImageView btnQuay;
    Button btnHome;
    TextView tvDiem;
    int dem;
    int cauHoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setControl();
        SetEvent();
       dem = getIntent().getIntExtra("getResult", 0);
       cauHoi=getIntent().getIntExtra("getTotalQuestion", 0);
       int kq=(10/cauHoi)*dem;
       tvDiem.setText(String.valueOf(kq));
    }

    private void SetEvent() {
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(itn);

            }
        });
        btnQuay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void setControl() {
        btnQuay = findViewById(R.id.btnQuay);
        btnHome = findViewById(R.id.btnHome);
        tvDiem = findViewById(R.id.tvDiem);
    }

}