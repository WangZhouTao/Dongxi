package com.zhuhean.dongxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuhean.dongxi.R;

/**
 * Created by vincent on 14/11/21.
 */
public class ClassifiedFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_classified,container,false);
        return view;
    }
}
