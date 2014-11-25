package com.zhuhean.dongxi.activity;

import com.zhuhean.dongxi.fragment.AdvertiseFragment;

/**
 * Created by vincent on 14/11/23.
 */
public class AdvertiseActivity extends SingleFragmentActivity {
    @Override
    protected android.support.v4.app.Fragment createFragment() {
        return new AdvertiseFragment();
    }
}
