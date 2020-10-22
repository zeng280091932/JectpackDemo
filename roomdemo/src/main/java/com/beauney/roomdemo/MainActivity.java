package com.beauney.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private TextView mContent;
    private Button mInsertBtn, mUpdateBtn, mDeleteBtn, mClearBtn;

    private WordViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(WordViewModel.class);
        mViewModel.getAllWordLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                if (words != null && words.size() > 0) {
                    StringBuilder builder = new StringBuilder();
                    for (Word word : words) {
                        builder.append(word.getId() + " : " + word.getWord() + " = " + word.getChineseMean() + "\n");
                    }
                    mContent.setText(builder.toString());
                } else {
                    mContent.setText("");
                }
            }
        });

        mContent = findViewById(R.id.content);
        mInsertBtn = findViewById(R.id.insert);
        mUpdateBtn = findViewById(R.id.update);
        mDeleteBtn = findViewById(R.id.delete);
        mClearBtn = findViewById(R.id.clear);

        mInsertBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello", "你好！");
                Word word2 = new Word("World", "世界。");
//                mWordDao.insertWords(word1, word2);
//                new InsertAsyncTask(mWordDao).execute(word1, word2);
                mViewModel.insert(word1, word2);
            }
        });
        mUpdateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "嗨，世界");
                word.setId(120);
//                mWordDao.updateWords(word);
//                new UpdateAsyncTask(mWordDao).execute(word);
                mViewModel.update(word);
            }
        });

        mDeleteBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "嗨，世界");
                word.setId(120);
//                mWordDao.deleteWords(word);
//                new DeleteAsyncTask(mWordDao).execute(word);
                mViewModel.delete(word);
            }
        });

        mClearBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                mWordDao.deleteAllWords();
//                new ClearAsyncTask(mWordDao).execute();
                mViewModel.clear();
            }
        });
    }
}
