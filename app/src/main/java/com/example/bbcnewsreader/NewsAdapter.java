package com.example.bbcnewsreader;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<News> items;


    public NewsAdapter(Context context, ArrayList<News> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public News getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.list_layout, parent, false);
        }


        News currentItem = (News) getItem(position);


        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);


        txtTitle.setText(currentItem.getTitle());


        return view;
    }
}
