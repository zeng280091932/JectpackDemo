package com.beauney.databindingdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author zengjiantao
 * @since 2020-10-09
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MyViewModel() {
        number = new MutableLiveData<>();
        number.setValue(0);
    }

    public MutableLiveData<Integer> getNumber() {
        return number;
    }

    public void addLikedNumber(int number) {
        this.number.setValue(this.number.getValue() + number);
    }
}
