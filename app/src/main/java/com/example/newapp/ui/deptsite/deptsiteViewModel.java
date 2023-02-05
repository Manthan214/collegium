package com.example.newapp.ui.deptsite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class deptsiteViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public deptsiteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}