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
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class NewQuestionFragment extends Fragment implements View.OnFocusChangeListener {
    LinearLayout layoutScreen;
    TextView tvTitle;
    EditText edtQuestion;
    EditText edtA;
    EditText edtB;
    EditText edtC;
    Spinner spnCorrect;
    Context context;
    int position;

    public NewQuestionFragment(Context context,int position) {
        this.context = context;
        this.position=position;
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

        tvTitle.setText("Câu "+(position+1));

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

    public Question getQuestionFromFragment() {
        String contentQuestion = edtQuestion.getText().toString().trim();
        List<String> answers=new ArrayList<>();
        answers.add(edtA.getText().toString());
        answers.add(edtB.getText().toString());
        answers.add(edtC.getText().toString());
        Question question=new Question(contentQuestion,answers,getContentCorrect(answers));
        return question;
    }

    private String getContentCorrect(List<String >answers) {
        if (spnCorrect.getSelectedItem().equals("Đáp án A")){
            return answers.get(0);
        }
        if (spnCorrect.getSelectedItem().equals("Đáp án B")){
            return answers.get(1);
        }
        if (spnCorrect.getSelectedItem().equals("Đáp án C")){
            return answers.get(2);
        }
        return "";
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        getDataSpinner();
    }
}
