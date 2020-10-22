package com.beauney.livedatademo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author zengjiantao
 * @since 2020-10-09
 */
public class ViewModelForLiveData extends ViewModel {
    private MutableLiveData<Integer> livedNumber;

    public ViewModelForLiveData() {
        livedNumber = new MutableLiveData<>();
        livedNumber.setValue(0);
    }

    public MutableLiveData<Integer> getLivedNumber() {
        return livedNumber;
    }

    public void addLikedNumber(int number) {
        livedNumber.setValue(livedNumber.getValue() + number);
    }
}
