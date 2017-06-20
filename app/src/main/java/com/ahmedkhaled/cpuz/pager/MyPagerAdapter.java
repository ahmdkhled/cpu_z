package com.ahmedkhaled.cpuz.pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ahmed Khaled on 6/17/2017.
 */


public class MyPagerAdapter extends FragmentPagerAdapter {

   private String[] tabsname =new String[]{"Device","Battery","System"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public int getCount() {
        return tabsname.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsname[position];
    }



}


