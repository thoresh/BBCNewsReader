package com.example.bbcnewsreader;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {News.class}, version = 1)

public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDao newsDAO();
    private static NewsDatabase instance ;

    public static NewsDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, NewsDatabase.class,"NewsDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
