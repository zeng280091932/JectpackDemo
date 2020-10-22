package com.beauney.roomdemo;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordLive() {
        return mRepository.getAllWordLive();
    }

    public void insert(Word... words) {
        mRepository.insert(words);
    }

    public void update(Word... words) {
        mRepository.update(words);
    }


    public void delete(Word... words) {
        mRepository.delete(words);
    }

    public void clear() {
        mRepository.clear();
    }
}
