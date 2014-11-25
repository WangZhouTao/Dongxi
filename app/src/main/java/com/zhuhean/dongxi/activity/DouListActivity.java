package com.zhuhean.dongxi.activity;

import android.support.v4.app.Fragment;

import com.zhuhean.dongxi.fragment.DouListFragment;

/**
 * Created by vincent on 14/11/24.
 */
public class DouListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DouListFragment();
    }
}
