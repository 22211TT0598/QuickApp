package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quickapp.R;
import com.example.quickapp.adapter.HistoryAdapter;
import com.example.quickapp.database.DbHistory;
import com.example.quickapp.models.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    HistoryAdapter adapter;
    ImageView btnkiem;
    LinearLayout btnDelete,btnSearch;
    ListView lstDS;
    List<History>danhsachTimKiem=new ArrayList<>();
    EditText edtTimKIem;
    List<History>danhsachlichsu=new ArrayList<>();
    DbHistory dbHistory=new DbHistory(this,null,null,1);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history);
        danhsachlichsu=dbHistory.getListHistory();
        SetControl();
        SetEvent();
    }

    private void SetControl() {
        edtTimKIem=findViewById(R.id.edtTimKIem);
        btnkiem=findViewById(R.id.btnKiem);
        btnSearch=findViewById(R.id.btnSearch);
        toolbar=findViewById(R.id.toolbar);
        btnDelete=findViewById(R.id.btnDelete);
        lstDS=findViewById(R.id.lstDS);
    }

    private void SetEvent() {
        //Set toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Danh sách môn học");

        adapter= new HistoryAdapter(danhsachlichsu,this);
        lstDS.setAdapter(adapter);

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
//        edtTimKIem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (v.getText().toString().isEmpty()){
//                    lstDS.setAdapter(adapter);
//                }
//                if (actionId== EditorInfo.IME_ACTION_GO){
//                    danhsachTimKiem.clear();
//                    for (History item:MainActivity.danhsachlichsu) {
//                        if ((item.getMssv()).contains(v.getText())){
//                            danhsachTimKiem.add(item);
//                        }
//                    }
//                    HistoryAdapter adapter1=new HistoryAdapter(danhsachTimKiem,HistoryActivity.this);
//                    lstDS.setAdapter(adapter1);
//                    edtTimKIem.clearFocus();
//                }
//                return false;
//            }
//        });
    }


}