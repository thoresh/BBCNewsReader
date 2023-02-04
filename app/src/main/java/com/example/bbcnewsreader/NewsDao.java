package com.example.bbcnewsreader;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class NewsDao {

    /**
     * Get all the Messages
     *
     * @return list of messages
     */
    @Query("SELECT * FROM News")
    public abstract List<News> getAll();


    /**
     * Get a Particular Message that matches the given Message Id
     *
     * @param newsId id to match
     * @return return message
     */
    @Query("SELECT * FROM News WHERE newsId=:newsId")
    public abstract News getNews(int newsId);


    /**
     * Insert new Message
     *
     * @param news to insert
     */
    @Insert
    public abstract void insert(News news);

    /**
     * Delete a Message
     *
     * @param news to delete
     */
    @Delete
    public abstract void delete(News news);

}
