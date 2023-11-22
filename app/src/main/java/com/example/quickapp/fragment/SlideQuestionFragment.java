package com.example.quickapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
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

public class SlideQuestionFragment extends Fragment
{
    public Question question;
    public Context context;

    public SlideQuestionFragment(Question question, Context context) {
        this.question = question;
        this.context = context;
    }

    @Nullable
    @Override
    //khởi tạo 1 fragment mới ánh xạ tới 1 layout
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_question,container,false);
        return view;
    }

// thực hiẹn các chức năng có trong fragment
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv=view.findViewById(R.id.Cau1);

        DbAnswer dbAnswer=new DbAnswer(getActivity(),null,null,1);
        List<Answer> answers=new ArrayList<>();
        for (Answer item:dbAnswer.getListAnswer()) {
            if(item.getIdQuestion().equals(question.getIdQuestion())){
                answers.add(item);
            }
        }

        tv.setText(question.getTitle());
        RadioButton radA=(RadioButton)view.findViewById(R.id.radA);
        radA.setText(answers.get(0).getText());
        RadioButton radb=(RadioButton)view.findViewById(R.id.radB);
        radb.setText(answers.get(1).getText());
        RadioButton radc=(RadioButton)view.findViewById(R.id.radC);
        radc.setText(answers.get(2).getText());

    }
}
