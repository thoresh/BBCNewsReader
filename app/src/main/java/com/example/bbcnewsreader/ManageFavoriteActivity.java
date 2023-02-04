package com.example.bbcnewsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManageFavoriteActivity extends BaseActivity {


    private NewsDatabase database;
    private Button btnFavorites;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtDate;
    private TextView txtLink;
    private Button btnBack;
    private Button btnDelete;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ViewGroup content = (ViewGroup) findViewById(R.id.baseContainer);
        getLayoutInflater().inflate(R.layout.activity_manage_favorite, content, true);


    }

}