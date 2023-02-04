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

    // database handle
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
        // setContentView(R.layout.activity_manage_favorite);

        ViewGroup content = (ViewGroup) findViewById(R.id.baseContainer);
        getLayoutInflater().inflate(R.layout.activity_manage_favorite, content, true);

        // create database
        this.database = NewsDatabase.getInstance(this);

        this.txtTitle = findViewById(R.id.lblTitle);
        this.txtDescription = findViewById(R.id.lblDescription);
        this.txtDate = findViewById(R.id.lblDate);
        this.txtLink = findViewById(R.id.lblURL);
        this.btnDelete = findViewById(R.id.btnDelete);
        this.btnBack = findViewById(R.id.btnBack);
        this.btnFavorites = findViewById(R.id.btnFavorites);

        Intent i = getIntent();


        DetailsFragment fragment = new DetailsFragment();

        System.out.println("--------------------------------------------------------");
        System.out.println("-" + i.getStringExtra("id") +"-");
        System.out.println("--------------------------------------------------------");

        this.id = Integer.parseInt(i.getStringExtra("id"));
        this.txtTitle.setText(i.getStringExtra("title"));
        this.txtDescription.setText(i.getStringExtra("description"));
        this.txtDate.setText(i.getStringExtra("date"));
        this.txtLink.setText(i.getStringExtra("link"));

        this.btnDelete.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteNews(v);
            }
        });

        this.btnFavorites.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moveFavorite(v);
            }
        });

        this.btnBack.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moveBack(v);
            }
        });
    }

    /**
     * Move back to the Main Activity Screen
     * @param view
     */
    public void moveBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Move back to the Favorite Activity
     * @param view
     */
    public void moveFavorite(View view) {
        Intent intent = new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }

    /**
     * Function to delete selected New item from the Favorite
     * @param view
     */
    public void deleteNews(View view) {

        News news = new News(this.txtTitle.getText().toString(), this.txtDescription.getText().toString(),
                this.txtDate.getText().toString(), this.txtLink.getText().toString());
        news.setNewsId(id);
        this.database.newsDAO().delete(news);
        Toast.makeText(this, "Nes Item has been deleted", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }
}