package com.ttth.myequalize;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import com.ttth.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragmentCurrent = getSupportFragmentManager().findFragmentById(R.id.fl_fragment);
        if (fragmentCurrent == null){
           addFragment(new MainFragment(), R.id.fl_fragment);
        }
    }

    private void addFragment(Fragment fragment, int layoutId) {
        String tag = fragment.getClass().getSimpleName();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        mTransaction.add(layoutId, fragment, tag);
        mTransaction.commit();
    }

    public void replaceFragment(Fragment fragment, int layoutId) {
        String tag = fragment.getClass().getSimpleName();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        mTransaction.addToBackStack(tag);
        mTransaction.replace(layoutId, fragment, tag);
        mTransaction.commit();
    }


}
