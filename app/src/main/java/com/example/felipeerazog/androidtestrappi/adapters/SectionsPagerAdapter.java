package com.example.felipeerazog.androidtestrappi.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.felipeerazog.androidtestrappi.fragments.MovieFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    String[] categories = new String[]{
            "popular",
            "top_rated",
            "upcoming"
    };

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        position++;
        return MovieFragment.newInstance(position, categories[position-1]);

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
