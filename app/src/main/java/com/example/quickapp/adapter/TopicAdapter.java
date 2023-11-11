package com.example.quickapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.models.Topic;

import java.util.List;

public class TopicAdapter extends BaseAdapter
{
    List<Topic> topics;
    Context context;
    public TopicAdapter(List<Topic> topics, Context context) {
        this.topics = topics;
        this.context = context;

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
        return vie;
    }
}
