package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quickapp.R;
import com.example.quickapp.database.DbHistory;
import com.example.quickapp.models.History;

import java.time.LocalDateTime;
import java.util.Date;

public class ResultActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnHome;
    TextView tvDiem;
    int dem;
    int cauHoi;
    DbHistory dbHistory=new DbHistory(this,null,null,1);;

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
        long dateEnd= SystemClock.elapsedRealtime()/1000;
        dbHistory.addHistory(String.valueOf(dbHistory.getListHistory().size()),String.valueOf(kq),String.valueOf(dateEnd-JoinActivity.dateStart)+" Giây","22211TT0826");
    }

    private void SetEvent() {
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(itn);
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.toolbar);
        btnHome = findViewById(R.id.btnHome);
        tvDiem = findViewById(R.id.tvDiem);
    }

}