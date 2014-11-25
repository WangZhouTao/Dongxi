package com.zhuhean.dongxi.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.zhuhean.dongxi.R;

/**
 * Created by vincent on 14/11/23.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected  abstract android.support.v4.app.Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment==null){
            fragment=createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
