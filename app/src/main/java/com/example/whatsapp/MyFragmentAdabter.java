package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdabter extends FragmentPagerAdapter {

    private int pageCount ;
    public MyFragmentAdabter(@NonNull FragmentManager fm, int behavior,int pageCount) {
        super(fm, behavior);
        this.pageCount=pageCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new StatusFragment();
            case 2:
                return new CallFragment();
            default:
                return new ChatFragment();
        }
    }
    @Override
    public int getCount() {
        return pageCount;
    }
}
