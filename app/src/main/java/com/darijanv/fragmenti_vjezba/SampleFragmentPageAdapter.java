package com.darijanv.fragmenti_vjezba;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SampleFragmentPageAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Light", "Dark"};

    public SampleFragmentPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FragmentLight();
            case 1: return new FragmentDark();
            default: return null;
        }
    }
}
