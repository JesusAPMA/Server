package com.example.jesus.pets.adaptader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.google.gson.JsonElement;
import com.example.jesus.pets.R;
import com.google.gson.*;
import java.util.ArrayList;
import com.google.gson.*;
/**
 * Created by jesus on 01/07/2016.
 */
public class PageAdapter extends FragmentPagerAdapter{

private ArrayList<Fragment> fragments;

    public PageAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {

      return fragments.size();
    }
}
