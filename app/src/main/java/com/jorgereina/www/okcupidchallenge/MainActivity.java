package com.jorgereina.www.okcupidchallenge;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jorgereina.www.okcupidchallenge.matches.MatchesFragment;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.jorgereina.www.okcupidchallenge.special.SpecialBlendFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private String matchesFragment;

    public String getMatchesFragment() {
        return matchesFragment;
    }

    public void setMatchesFragment(String matchesFragment) {
        this.matchesFragment = matchesFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new OkcViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
}
