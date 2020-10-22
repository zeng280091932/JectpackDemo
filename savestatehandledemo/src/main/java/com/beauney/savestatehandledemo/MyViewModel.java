package com.beauney.savestatehandledemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @author zengjiantao
 * @since 2020-10-21
 */
public class MyViewModel extends ViewModel {
    private static final String KEY_NUMBER = "key_number";
    private SavedStateHandle mHandle;

    public MyViewModel(SavedStateHandle handle) {
        mHandle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!mHandle.contains(KEY_NUMBER)) {
            mHandle.set(KEY_NUMBER, 0);
        }
        return mHandle.getLiveData(KEY_NUMBER);
    }

    public void add() {
        getNumber().setValue(getNumber().getValue() + 1);
    }
}
