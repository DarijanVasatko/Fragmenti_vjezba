package com.darijanv.fragmenti_vjezba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.sliding_tabs);

        // Dodavanje tabova (Dark i Light)
        tabLayout.addTab(tabLayout.newTab().setText("Dark"));
        tabLayout.addTab(tabLayout.newTab().setText("Light"));


        // Zadatak 1 - Toast poruke


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Light Tab", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Dark Tab", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });






        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setFrame(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });



        ViewPager viewPager = findViewById(R.id.viewpager);
        SampleFragmentPageAdapter adapter = new SampleFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setFrame(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (position) {
            case 0:
                ft.replace(R.id.frame_container, new FragmentLight());
                break;
            case 1:
                ft.replace(R.id.frame_container, new FragmentDark());
                break;
        }
        ft.commit();
    }
}