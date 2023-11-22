package com.example.quickapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.database.DbAccCount;
import com.example.quickapp.models.Account;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText edtTenDang, edtMatKhau;

    Button btnRegister, btnLogin;

    List<Account> Acc = new ArrayList<>();
    DbAccCount dbAcccount = new DbAccCount(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Acc = dbAcccount.getListAccount();
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(inte);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account account = new Account();
                for (Account item : dbAcccount.getListAccount()) {
                    if (item.getTenDangNhap().equals(edtTenDang.getText().toString().trim())) {
                        account = item;
                        break;
                    }
                }
                if (account.getTenDangNhap()!="") {
                    if (account.getPass().equals(edtMatKhau.getText().toString().trim())) {
                        Intent inte = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(inte);
                    } else {
                        AlertDialog.Builder da = new AlertDialog.Builder(LoginActivity.this);
                        da.setTitle("Thông Báo");
                        da.setMessage("Mật Khẩu Sai");
                        da.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                    }
                }
                else {
                    AlertDialog.Builder da = new AlertDialog.Builder(LoginActivity.this);
                    da.setTitle("Thông Báo");
                    da.setMessage("Tai khoan khong ton tai");
                    da.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                }
            }
        });
    }

    private void setControl() {
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        edtTenDang = findViewById(R.id.edtTenDang);
        edtMatKhau = findViewById(R.id.edtMatKhau);
    }
}