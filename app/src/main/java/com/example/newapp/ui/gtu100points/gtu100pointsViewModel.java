package com.example.newapp.ui.gtu100points;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class gtu100pointsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public gtu100pointsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}