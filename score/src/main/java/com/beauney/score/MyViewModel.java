package com.beauney.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author zengjiantao
 * @since 2020-10-20
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> mATeamScore;
    private MutableLiveData<Integer> mBTeamScore;

    private int mAScore;
    private int mBScore;

    public MyViewModel() {
        mATeamScore = new MutableLiveData<>();
        mATeamScore.setValue(0);

        mBTeamScore = new MutableLiveData<>();
        mBTeamScore.setValue(0);
    }

    public MutableLiveData<Integer> getATeamScore() {
        return mATeamScore;
    }

    public MutableLiveData<Integer> getBTeamScore() {
        return mBTeamScore;
    }

    public void addATeamScore(int score){
        mAScore = mATeamScore.getValue();
        mBScore = mBTeamScore.getValue();
        mATeamScore.setValue(mATeamScore.getValue() + score);
    }

    public void addBTeamScore(int score){
        mAScore = mATeamScore.getValue();
        mBScore = mBTeamScore.getValue();
        mBTeamScore.setValue(mBTeamScore.getValue() + score);
    }

    public void undo(){
        mATeamScore.setValue(mAScore);
        mBTeamScore.setValue(mBScore);
    }

    public void reset(){
        mAScore = mATeamScore.getValue();
        mBScore = mBTeamScore.getValue();
        mATeamScore.setValue(0);
        mBTeamScore.setValue(0);
    }
}
