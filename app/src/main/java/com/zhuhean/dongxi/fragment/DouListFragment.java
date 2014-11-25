package com.zhuhean.dongxi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.adapter.GuessUserLikesGridViewAdapter;
import com.zhuhean.dongxi.model.GuessUserLikesItem;

import java.util.ArrayList;

/**
 * Created by vincent on 14/11/24.
 */
public class DouListFragment extends Fragment {
    private View rootView;
    private GridView douListGridView;
    private ArrayList<GuessUserLikesItem> itemArrayList;
    private GuessUserLikesGridViewAdapter gridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_dou_list,container,false);
        douListGridView=(GridView)rootView.findViewById(R.id.dou_list_grid_view);
        itemArrayList=new ArrayList<GuessUserLikesItem>();
        for(int i=0;i<10;i++){
            itemArrayList.add(new GuessUserLikesItem(R.drawable.pic_b,"232","whatever"));
        }
        gridViewAdapter=new GuessUserLikesGridViewAdapter(getActivity(),itemArrayList);

        douListGridView.setAdapter(gridViewAdapter);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_share:
                shareUrl();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareUrl(){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,"wait");
        startActivity(Intent.createChooser(shareIntent,"分享至..."));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_share,menu);
    }
}
