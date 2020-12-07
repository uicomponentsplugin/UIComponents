package com.mvvm.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public MutableLiveData<Integer> getCount() {
        return count;
    }

    public void addCounter() {
        this.count.setValue(count.getValue() == null ? 1 : count.getValue() + 1);
    }
}
