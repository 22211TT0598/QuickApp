package com.example.quickapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.activity.HistoryActivity;
import com.example.quickapp.activity.JoinActivity;
import com.example.quickapp.activity.TopicActivity;
import com.example.quickapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends BaseAdapter
{
    List<Topic> topics;
    Context context;

    Intent intent;
    public TopicAdapter(List<Topic> phu, Context context,Intent intent)
    {
        this.topics=phu;
        this.context=context;
        this.intent=intent;
    }
    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int i) {
        return topics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vie = LayoutInflater.from(context).inflate(R.layout.item_course,null);
        TextView tv =vie.findViewById(R.id.tvDD);
        tv.setText(topics.get(i).getNameTopic());
        int navigate=intent.getIntExtra("Navigate",0);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(navigate==2)
                {
                    Intent iten=new Intent(context,JoinActivity.class);
                    iten.putExtra("getTopic",topics.get(i));
                    context.startActivity(iten);
                }
                if(navigate==3)
                {
                    Intent it=new Intent(context, HistoryActivity.class);
                    it.putExtra("getTopic",topics.get(i));
                    context.startActivity(it);
                }

            }
        });

        return vie;
    }
}
