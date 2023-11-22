package com.example.quickapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quickapp.R;
import com.example.quickapp.database.DbAnswer;
import com.example.quickapp.database.DbQuestion;
import com.example.quickapp.models.Answer;
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class NewQuestionFragment extends Fragment implements View.OnFocusChangeListener {
    LinearLayout layoutScreen;
    TextView tvTitle;
    public EditText edtQuestion;
    public EditText edtA;
    public EditText edtB;
    public EditText edtC;
    public Spinner spnCorrect;
    Context context;
    String idTopic;
    int index;
    DbQuestion dbQuestion=new DbQuestion(getActivity(),null,null,1);
    DbAnswer dbAnswer=new DbAnswer(getActivity(),null,null,1);

    public NewQuestionFragment(Context context,int index,String idTopic) {
        this.context = context;
        this.index=index;
        this.idTopic=idTopic;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_exam_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutScreen=view.findViewById(R.id.layoutScreen);
        tvTitle=view.findViewById(R.id.tvTitle);
        edtQuestion = view.findViewById(R.id.edtQuestion);
        edtA = view.findViewById(R.id.edtDapAnA);
        edtB = view.findViewById(R.id.edtDapAnB);
        edtC = view.findViewById(R.id.edtDapAnC);
        spnCorrect = view.findViewById(R.id.spinnerCorrect);

        tvTitle.setText("Câu "+(index+1));

        layoutScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.clearFocus();
            }
        });
        edtA.setOnFocusChangeListener(this);
        edtB.setOnFocusChangeListener(this);
        edtC.setOnFocusChangeListener(this);
    }

    private void getDataSpinner() {
        String answerA = edtA.getText().toString().trim();
        String answerB = edtB.getText().toString().trim();
        String answerC = edtC.getText().toString().trim();
        ArrayList<String> arrayList = new ArrayList<>();
        if ((!answerA.isEmpty()) && (!answerB.isEmpty()) && (!answerC.isEmpty())) {
            arrayList.add("Đáp án A");
            arrayList.add("Đáp án B");
            arrayList.add("Đáp án C");
        }
        //Set data for spinner
        ArrayAdapter adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayList);
        spnCorrect.setAdapter(adapter);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        getDataSpinner();
    }
}
