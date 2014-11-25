package com.zhuhean.dongxi.activity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.fragment.ThingsDetailFragment;

/**
 * Created by vincent on 14/11/23.
 */
public class ThingsItemDetailActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_container);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#11000000")));
        //actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#550000ff")));
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment==null){
            fragment=createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }

    protected Fragment createFragment() {
        return new ThingsDetailFragment();
    }
}
