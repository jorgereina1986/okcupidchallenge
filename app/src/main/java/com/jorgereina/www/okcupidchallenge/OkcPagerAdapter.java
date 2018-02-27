package com.jorgereina.www.okcupidchallenge;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jorgereina on 2/26/18.
 */

public class OkcPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 2;

    public OkcPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SpecialBlendFragment();
                break;
            case 1:
                fragment = new MatchesFragment();
                break;
            default:
                return null;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SPECIAL BLEND";
            case 1:
                return "MATCHES";
            default:
                return null;
        }
    }
}
