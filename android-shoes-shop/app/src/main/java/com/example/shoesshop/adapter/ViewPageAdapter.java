package com.example.shoesshop.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.example.shoesshop.fragment.FragmentCart;
import com.example.shoesshop.fragment.FragmentHome;
import com.example.shoesshop.fragment.FragmentNotification;
import com.example.shoesshop.fragment.FragmentOder;
import com.example.shoesshop.fragment.MyProfileFragment;


public class ViewPageAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;


    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentHome();
            case 1: return new FragmentCart();
            case 2: return new FragmentOder();
            case 3: return new MyProfileFragment();
            default:
                throw new IllegalStateException("Invalid position: " + position);

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
