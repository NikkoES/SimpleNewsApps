package com.example.nikkoekasaputra.simplenewsapps.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikkoekasaputra.simplenewsapps.R;
import com.example.nikkoekasaputra.simplenewsapps.adapter.ViewPagerAdapter;
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

        getSupportActionBar().setTitle("News Apps");

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

        TextView sportTab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        sportTab.setText("Sport");
        tabLayout.getTabAt(2).setCustomView(sportTab);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScienceFragment(), "Science");
        adapter.addFragment(new TechnologyFragment(), "Technology");
        adapter.addFragment(new SportFragment(), "Sport");
        viewPager.setAdapter(adapter);
    }

}
