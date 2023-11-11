package com.example.quickapp.adapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.activity.HistoryActivity;
import com.example.quickapp.models.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends BaseAdapter {
     List<History> list;
    Context context;

    public HistoryAdapter(List<History> list, Context context) {
        this.list = list;
        this.context=context;
    }

    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return list.size();
    }

    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return list.get(position);
    }

    public long getItemId(int position) {
        //Trả về một ID của phần
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới

        View viewProduct= LayoutInflater.from(context).inflate(R.layout.item_history,null);

        History product = list.get(position);
        ((TextView) viewProduct.findViewById(R.id.mssv)).setText("mssv: "+ product.getMssv());
        ((TextView) viewProduct.findViewById(R.id.name)).setText("name : "+ product.getName());
        ((TextView) viewProduct.findViewById(R.id.sorce)).setText("sorce:  "+ product.getSorce());
        ((TextView) viewProduct.findViewById(R.id.Finishtime)).setText("Finish time: "+ product.getFinishtime());

        return viewProduct;

    }
}
