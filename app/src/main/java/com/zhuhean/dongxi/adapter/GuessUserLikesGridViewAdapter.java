package com.zhuhean.dongxi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.model.GuessUserLikesItem;

import java.util.ArrayList;

/**
 * Created by vincent on 14/11/24.
 */
public class GuessUserLikesGridViewAdapter extends BaseAdapter {
    private ArrayList<GuessUserLikesItem> userLikesItemArrayList;
    private Context context;

    public GuessUserLikesGridViewAdapter(Context context,ArrayList<GuessUserLikesItem> userLikesItemArrayList){
        this.context=context;
        this.userLikesItemArrayList=userLikesItemArrayList;
    }


    @Override
    public int getCount() {
        return userLikesItemArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return userLikesItemArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView=inflater.inflate(R.layout.gusses_user_like_grid_view_item,viewGroup,false);
        return rootView;
    }
}
