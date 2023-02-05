package com.example.newapp.ui.gtugrade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class gtugradeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public gtugradeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}