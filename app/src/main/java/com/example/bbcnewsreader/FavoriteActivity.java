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
        // setContentView(R.layout.activity_favorite);

        ViewGroup content = (ViewGroup) findViewById(R.id.baseContainer);
        getLayoutInflater().inflate(R.layout.activity_favorite, content, true);

        this.progressBar = findViewById(R.id.progressBar);

        // create database
        this.database = NewsDatabase.getInstance(this);

        this.lstFavorites = findViewById(R.id.lstTitles);

        List<News> all = this.database.newsDAO().getAll();
        this.newsList = new ArrayList<>(all);
        this.progressBar.setProgress(all.size());

        // instantiate the custom list adapter
        adapter = new NewsAdapter(this, newsList);

        // get the ListView
        lstFavorites  = findViewById(R.id.lstFavorites);
        lstFavorites.setAdapter(adapter);

        lstFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = adapter.getItem(position);
                Intent intent = new Intent(FavoriteActivity.this, ManageFavoriteActivity.class);
                intent.putExtra("id", String.valueOf(news.getNewsId()));
                intent.putExtra("title", news.getTitle());
                intent.putExtra("description", news.getDescription());
                intent.putExtra("date", news.getDate());
                intent.putExtra("link", news.getUrl());
                startActivity(intent);
            }
        });
    }
}