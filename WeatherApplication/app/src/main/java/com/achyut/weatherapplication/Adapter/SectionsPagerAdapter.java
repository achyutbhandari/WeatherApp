package com.achyut.weatherapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.achyut.weatherapplication.DailyFragment;
import com.achyut.weatherapplication.HourlyFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position ) {
        // getItem is called to instantiate the fragment for the given page.
        Fragment fragment = null;
        switch (position) {
            case 0 :
                fragment =  DailyFragment.newInstance(position +1) ;
                break;
            case  1 :
                fragment = HourlyFragment.newInstance(position +1)  ;
                break;


        }
        return fragment ;

    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Daily";
            case 1:
                return "Hourly";

        }
        return null;
    }
}