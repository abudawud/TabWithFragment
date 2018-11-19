package project.envoss.com.calculatorbalok.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import project.envoss.com.calculatorbalok.MainActivity;
import project.envoss.com.calculatorbalok.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.add(
                R.id.frame_container,
                new HomeFragment(),
                HomeFragment.class.getSimpleName());

        transaction.commit();
    }
}
