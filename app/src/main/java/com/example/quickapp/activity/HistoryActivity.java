package com.example.quickapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.adapter.HistoryAdapter;
import com.example.quickapp.models.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    HistoryAdapter adapter;
    ImageView btnkiem,btnBack,btnMenu;
    LinearLayout btnDelete,btnSearch;
    ListView lstDS;
    List<History>danhsachlichsu=new ArrayList<>();
    List<History>danhsachTimKiem=new ArrayList<>();
    EditText edtTimKIem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history);
        SetControl();
        SetEvent();
        registerForContextMenu(btnMenu);
    }

    private void SetControl() {
        edtTimKIem=findViewById(R.id.edtTimKIem);
        btnkiem=findViewById(R.id.btnKiem);
        btnSearch=findViewById(R.id.btnSearch);
        btnBack=findViewById(R.id.btnBack);
        btnMenu=findViewById(R.id.btnMenu);
        btnDelete=findViewById(R.id.btnDelete);
        lstDS=findViewById(R.id.lstDS);
        danhsachlichsu=new ArrayList<>();
        danhsachlichsu.add(new History("22211TT0826","Nguyễn Phong Phú","2","12"));
        danhsachlichsu.add(new History("22211TT0085","Phạm Thế Minh","1","13"));
        danhsachlichsu.add(new History("22211TT05898","Phạm Thị Bảo Châu","0","14"));
         adapter= new HistoryAdapter(danhsachlichsu,this);
        lstDS.setAdapter(adapter);


    }

    private void SetEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lstDS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                btnDelete.setVisibility(View.VISIBLE);
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        danhsachlichsu.remove(position);
                        adapter.notifyDataSetChanged();
                        btnDelete.setVisibility(View.GONE);
                    }
                });
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.btnHouse)
        {
            Intent in=new Intent(HistoryActivity.this,MainActivity.class);
            startActivity(in);
        }
        if(item.getItemId()==R.id.btnXoaTatCa)
        {
            danhsachlichsu.clear();
            adapter.notifyDataSetChanged();
        }
        if(item.getItemId()==R.id.btnTim)
        {
           btnSearch.setVisibility(View.VISIBLE);
           dsCanTim();

        }
        return super.onOptionsItemSelected(item);
    }

    private void dsCanTim() {
        edtTimKIem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (v.getText().toString().isEmpty()){
                    lstDS.setAdapter(adapter);
                }
                if (actionId== EditorInfo.IME_ACTION_GO){
                    danhsachTimKiem.clear();
                    for (History item:danhsachlichsu) {
                        if ((item.getMssv()).contains(v.getText())){
                            danhsachTimKiem.add(item);
                        }
                    }
                    HistoryAdapter adapter1=new HistoryAdapter(danhsachTimKiem,HistoryActivity.this);
                    lstDS.setAdapter(adapter1);
                    edtTimKIem.clearFocus();
                }
                return false;
            }
        });
    }


}