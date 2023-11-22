package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.database.DbAccCount;

public class RegisterActivity extends AppCompatActivity {
    EditText edtMssv, edtTenDangNhap, edtPass, edtPassXacNhan;

    Button btnDangKi;
    DbAccCount dbAccount = new DbAccCount(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SetControl();
        SetEvent();
    }

    private void SetEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbAccount.addAccount(edtMssv.getText().toString().trim(), edtTenDangNhap.getText().toString().trim(), edtPass.getText().toString().trim());
                if (dbAccount.getListAccount().size() > 0) {
                    Intent inte = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(inte);
                }
                Toast.makeText(RegisterActivity.this, String.valueOf(dbAccount.getListAccount().size()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SetControl() {
        edtMssv = findViewById(R.id.edtMssv);
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtPass = findViewById(R.id.edtPass);
        edtPassXacNhan = findViewById(R.id.edtPassXacNhan);
        btnDangKi = findViewById(R.id.btnDangKi);

    }
}