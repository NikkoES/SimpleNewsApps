package com.example.nikkoekasaputra.simplenewsapps.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikkoekasaputra.simplenewsapps.R;
import com.example.nikkoekasaputra.simplenewsapps.adapter.ViewPagerAdapter;
import com.example.nikkoekasaputra.simplenewsapps.fragment.BusinessFragment;
import com.example.nikkoekasaputra.simplenewsapps.fragment.EntertainmentFragment;
import com.example.nikkoekasaputra.simplenewsapps.fragment.HealthFragment;
import com.example.nikkoekasaputra.simplenewsapps.fragment.ScienceFragment;
import com.example.nikkoekasaputra.simplenewsapps.fragment.SportFragment;
import com.example.nikkoekasaputra.simplenewsapps.fragment.TechnologyFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_title);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTab();
    }

    private void setupTab() {
        TextView scienceTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        scienceTab.setText("Science");
        tabLayout.getTabAt(0).setCustomView(scienceTab);

        TextView technologyTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        technologyTab.setText("Technology");
        tabLayout.getTabAt(1).setCustomView(technologyTab);

        TextView businessTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        businessTab.setText("Business");
        tabLayout.getTabAt(2).setCustomView(businessTab);

        TextView entertainmentTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        entertainmentTab.setText("Entertainment");
        tabLayout.getTabAt(3).setCustomView(entertainmentTab);

        TextView sportTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        sportTab.setText("Sport");
        tabLayout.getTabAt(4).setCustomView(sportTab);

        TextView healthTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        healthTab.setText("Health");
        tabLayout.getTabAt(5).setCustomView(healthTab);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScienceFragment(), "Science");
        adapter.addFragment(new TechnologyFragment(), "Technology");
        adapter.addFragment(new BusinessFragment(), "Business");
        adapter.addFragment(new EntertainmentFragment(), "Entertainment");
        adapter.addFragment(new SportFragment(), "Sport");
        adapter.addFragment(new HealthFragment(), "Health");
        viewPager.setAdapter(adapter);
    }

}
