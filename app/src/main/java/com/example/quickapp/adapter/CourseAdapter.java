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
<<<<<<< HEAD

    public CourseAdapter(List<Course> course, Context context)
    {
        this.course=course;
        this.context=context;
=======
    Intent intent;

    public CourseAdapter(List<Course> course, Context context,Intent intent)
    {
        this.course=course;
        this.context=context;
        this.intent=intent;
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
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
<<<<<<< HEAD
=======
      int navigate=intent.getIntExtra("Navigate",0);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(navigate==2)
                {
                    Intent intent1=new Intent(context, TopicActivity.class);
                    intent1.putExtra("getTopics",course.get(i));
                    intent1.putExtra("Navigate",2);
                    context.startActivity(intent1);
                }
               if(navigate==3)
               {
                   Intent nte=new Intent(context, TopicActivity.class);
                   nte.putExtra("getTopics",course.get(i));
                   nte.putExtra("Navigate",3);
                   context.startActivity(nte);
               }


            }
        });
>>>>>>> b65a0145ffb89d9cc2aa5bb30f6fc21d9acb2952
        return vie;
    }
}
