package com.beauney.roomdemo;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWordLive;

    public WordRepository(Context context) {
        mWordDao = WordDatabase.getInstance(context).getWordDao();
        mAllWordLive = mWordDao.getAllWordLive();
    }

    public LiveData<List<Word>> getAllWordLive() {
        return mAllWordLive;
    }

    public void insert(Word... words) {
        new InsertAsyncTask(mWordDao).execute(words);
    }

    public void update(Word... words) {
        new UpdateAsyncTask(mWordDao).execute(words);
    }


    public void delete(Word... words) {
        new DeleteAsyncTask(mWordDao).execute(words);
    }

    public void clear() {
        new ClearAsyncTask(mWordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mWordDao;

        public InsertAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.insertWords(words);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mWordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.updateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mWordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.deleteWords(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao mWordDao;

        public ClearAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDao.deleteAllWords();
            return null;
        }
    }
}
