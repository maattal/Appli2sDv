package com.example.appli2sdv.ui.User_History_delivering;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class User_History_deliveringViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public User_History_deliveringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}