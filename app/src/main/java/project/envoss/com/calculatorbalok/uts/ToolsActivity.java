package project.envoss.com.calculatorbalok.uts;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import project.envoss.com.calculatorbalok.R;
import project.envoss.com.calculatorbalok.adapter.ViewPagerAdapter;
import project.envoss.com.calculatorbalok.models.DataMahasiswa;
import project.envoss.com.calculatorbalok.uts.fragment.KonversiNtTFragment;
import project.envoss.com.calculatorbalok.uts.fragment.KonversiRomFragment;
import project.envoss.com.calculatorbalok.uts.fragment.KonversiUangFragment;
import project.envoss.com.calculatorbalok.uts.fragment.ProfilFragment;

public class ToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> judulTab = new ArrayList<>();

        DataMahasiswa dataMahasiswa = getIntent().getExtras().getParcelable(RegisterActivity.EXTRA_MAHASISWA);

        fragmentList.add(ProfilFragment.newInstance(dataMahasiswa));
        fragmentList.add(new KonversiUangFragment());
        fragmentList.add(new KonversiRomFragment());
        fragmentList.add(new KonversiNtTFragment());

        judulTab.add("Profil Saya");
        judulTab.add("Konversi Uang");
        judulTab.add("Konversi Romawi");
        judulTab.add("Konversi Terbilang");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), judulTab, fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
