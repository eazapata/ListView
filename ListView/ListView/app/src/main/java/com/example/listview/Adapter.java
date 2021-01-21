package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> list;

    public Adapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = (Item) getItem(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item,null);
        TextView text = convertView.findViewById(R.id.listText);
        text.setText(item.getActivityName());
        return convertView;
    }
}
