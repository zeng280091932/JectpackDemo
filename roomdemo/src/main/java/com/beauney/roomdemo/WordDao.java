package com.beauney.roomdemo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
@Dao
public interface WordDao {
    @Insert
    void insertWords(Word... words);

    @Update
    void updateWords(Word... word);

    @Delete
    void deleteWords(Word... word);

    @Query("DELETE FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
//    List<Word> getAllWord();
    LiveData<List<Word>> getAllWordLive();
}
