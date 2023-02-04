package com.example.bbcnewsreader;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class NewsDao {


    @Query("SELECT * FROM News")
    public abstract List<News> getAll();



    @Query("SELECT * FROM News WHERE newsId=:newsId")
    public abstract News getNews(int newsId);



    @Insert
    public abstract void insert(News news);


    @Delete
    public abstract void delete(News news);

}
