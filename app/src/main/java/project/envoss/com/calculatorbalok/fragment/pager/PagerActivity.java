package project.envoss.com.calculatorbalok.fragment.pager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import project.envoss.com.calculatorbalok.R;
import project.envoss.com.calculatorbalok.adapter.ViewPagerAdapter;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> judulTab = new ArrayList<>();

        fragmentList.add(new DocumentFragment());
        fragmentList.add(new MovieFragment());
        fragmentList.add(new PictureFragment());

        judulTab.add("Dokumen");
        judulTab.add("Movie");
        judulTab.add("Picture");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), judulTab, fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
