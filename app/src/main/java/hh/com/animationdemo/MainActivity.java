package hh.com.animationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import hh.com.animationdemo.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    public static Context mContext;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        startFragment(MainFragment.getInstance(), null);
        mContext = this;
    }

    public void startFragment(Fragment newFragment, Fragment oldFragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (oldFragment != null) {
            transaction.remove(oldFragment);
            transaction.addToBackStack("back");
        }
        transaction.add(R.id.fragments, newFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }
}
