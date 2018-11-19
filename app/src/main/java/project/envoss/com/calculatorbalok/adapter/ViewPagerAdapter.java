package project.envoss.com.calculatorbalok.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by xkill on 12/11/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> judulTab;
    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<String> judulTab, List<Fragment> fragmentList) {
        super(fm);
        this.judulTab = judulTab;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return judulTab.get(position);
    }
}
