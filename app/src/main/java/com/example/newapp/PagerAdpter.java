package com.example.newapp;

import com.example.newapp.ui.mails.tabs.All;
import com.example.newapp.ui.mails.tabs.Events;
import com.example.newapp.ui.mails.tabs.Exam;
import com.example.newapp.ui.mails.tabs.Sports;

public class PagerAdpter extends androidx.fragment.app.FragmentPagerAdapter {
    private int noOfTabs;
    public PagerAdpter(@androidx.annotation.NonNull @org.jetbrains.annotations.NotNull androidx.fragment.app.FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs=noOfTabs;
    }


    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new All();
            case 1:
                return new Events();
            case 2:
                return new Sports();
            case 3:
                return new Exam();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
