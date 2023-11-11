package com.example.quickapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quickapp.R;
import com.example.quickapp.activity.ListQuestionActivity;
import com.example.quickapp.activity.MainActivity;
import com.example.quickapp.activity.UpdateQuestionActivity;
import com.example.quickapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class ShowQuestionAdapter extends BaseAdapter {
    Context context;
    List<Question> arrayList;

    public ShowQuestionAdapter(Context context, List<Question> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_question, null);
        TextView lbQuestion = view.findViewById(R.id.tv_question);
        TextView tvQuestion = view.findViewById(R.id.question_content);
        TextView tvA = view.findViewById(R.id.answer_content1);
        TextView tvB = view.findViewById(R.id.answer_content2);
        TextView tvC = view.findViewById(R.id.answer_content3);
        TextView tvCorrect = view.findViewById(R.id.correct_answer);
        Button btnEdit = view.findViewById(R.id.btnEdit);
        Button btnDelete = view.findViewById(R.id.btnDelete);
        LinearLayout layout = view.findViewById(R.id.layoutOption);

        if (arrayList.get(i).isShowLayoutEdit==true){
            layout.setVisibility(View.VISIBLE);
        }
        else {
            layout.setVisibility(View.GONE);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(i);
                notifyDataSetChanged();
                layout.setVisibility(View.GONE);
            }
        });

        lbQuestion.setText("Câu " + (i + 1) + ": ");
        tvQuestion.setText(arrayList.get(i).getTitle());
        tvA.setText("A." + arrayList.get(i).getAnswers().get(0));
        tvB.setText("B." + arrayList.get(i).getAnswers().get(1));
        tvC.setText("C." + arrayList.get(i).getAnswers().get(2));
        tvCorrect.setText(arrayList.get(i).getCorrect());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.GONE);
                Intent intent = new Intent(context, UpdateQuestionActivity.class);
                intent.putExtra("getQuestionId",i);
                context.startActivity(intent);
            }
        });
        return view;
    }
}