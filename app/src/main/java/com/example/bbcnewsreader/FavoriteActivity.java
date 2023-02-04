package com.example.bbcnewsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends BaseActivity {

    protected ListView lstFavorites;
    private ArrayList<News> newsList;
    private NewsAdapter adapter;
    private NewsDatabase database;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ViewGroup content = (ViewGroup) findViewById(R.id.baseContainer);
        getLayoutInflater().inflate(R.layout.activity_favorite, content, true);


    }
}