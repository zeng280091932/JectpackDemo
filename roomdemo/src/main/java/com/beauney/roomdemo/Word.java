package com.beauney.roomdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_word")
    private String word;

    @ColumnInfo(name = "chinese_mean")
    private String chineseMean;

    public Word(String word, String chineseMean) {
        this.word = word;
        this.chineseMean = chineseMean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChineseMean() {
        return chineseMean;
    }

    public void setChineseMean(String chineseMean) {
        this.chineseMean = chineseMean;
    }
}
