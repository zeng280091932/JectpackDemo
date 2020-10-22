package com.beauney.roomdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase sInstance;

    public static synchronized WordDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_db")
                    .build();
        }
        return sInstance;
    }

    public abstract WordDao getWordDao();
}
