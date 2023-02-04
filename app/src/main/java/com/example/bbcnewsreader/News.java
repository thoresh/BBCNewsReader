package com.example.bbcnewsreader;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {


    @PrimaryKey(autoGenerate = true)
    private int newsId;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="description")
    private String description;

    @ColumnInfo(name="date")
    private String date;

    @ColumnInfo(name="url")
    private String url;


    public News() {
    }


    public News(String title, String description, String date, String url) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

