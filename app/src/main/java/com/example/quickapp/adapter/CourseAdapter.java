package com.example.quickapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.activity.TopicActivity;
import com.example.quickapp.models.Course;

import java.util.List;

public class CourseAdapter extends BaseAdapter {
    List<Course> course;
    Context context;

    public CourseAdapter(List<Course> course, Context context)
    {
        this.course=course;
        this.context=context;
    }
    @Override
    public int getCount() {
        return course.size();
    }

    @Override
    public Object getItem(int i) {
        return course.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vie = LayoutInflater.from(context).inflate(R.layout.item_course,null);
        TextView tv =vie.findViewById(R.id.tvDD);
        tv.setText(course.get(i).getNameCourse());
        return vie;
    }
}
