package com.beauney.roomdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
//                    .addMigrations(MIGRATION_2_3) //自定义数据库升级策略
                    .fallbackToDestructiveMigration() //粗暴的数据库升级策略，直接清除原有数据
                    .build();
        }
        return sInstance;
    }

    public abstract WordDao getWordDao();

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL ,english_word TEXT," +
                    "chinese_meaning TEXT)");
            database.execSQL("INSERT INTO word_temp (id,english_word,chinese_meaning) " +
                    "SELECT id,english_word,chinese_meaning FROM word");
            database.execSQL("DROP TABLE word");
            database.execSQL("ALTER TABLE word_temp RENAME to word");
        }
    };
}
