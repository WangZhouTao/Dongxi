package com.zhuhean.dongxi.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.fragment.ClassifiedFragment;
import com.zhuhean.dongxi.fragment.FindNewThingFragment;
import com.zhuhean.dongxi.library.PagerSlidingTabStrip;
import com.zhuhean.dongxi.utils.MyToast;

/**
 * Created by vincent on 14/11/21.
 */
public class DongxiMainScreenActivity extends FragmentActivity {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private TextView openLoginDialogTextView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private CharSequence drawerTitle;
    private CharSequence title;
    private String[] menu_content={
            "首页","设置"
    };

    private FindNewThingFragment findNewThingFragment;
    private ClassifiedFragment classifiedFragment;
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private TextView loginTextView;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongxi_main_screen);

        handleActionBar();
        initView();
        setSlidingMenu();
        setTabs();
        createLoginDialog();

    }

    private void createLoginDialog(){
        dialog=new Dialog(DongxiMainScreenActivity.this);
        dialog.setContentView(R.layout.login_dailog);
        loginTextView=(TextView)dialog.findViewById(R.id.login_dialog_login_text_view);
        dialog.setTitle("登录东西享受个性化推荐！");
        openLoginDialogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyToast.showLong(DongxiMainScreenActivity.this, "Login");
            }
        });

    }

    private void setTabs(){
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);
        setTabValues();
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return listView.onTouchEvent(event);
    }

    private void setSlidingMenu(){
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.menu_list_view_item,menu_content));
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawer,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        listView.setOnItemClickListener(new MyListViewItemClickListener());
    }

    private void initView(){
        openLoginDialogTextView=(TextView)findViewById(R.id.menu_login_text_view);
        drawerTitle=title=getTitle();
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        listView=(ListView)findViewById(R.id.menu_list_view);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    }

    private void handleActionBar(){
        getActionBar().show();
        getActionBar().setTitle("");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void setTabValues(){
        tabs.setShouldExpand(true);
        tabs.setDividerColor(Color.GRAY);
        tabs.setUnderlineHeight(1);
        tabs.setIndicatorHeight(4);
        tabs.setTextSize(24);
        tabs.setIndicatorColor(Color.parseColor("#45c01a"));
        tabs.setTabBackground(0);
    }

    private class MyListViewItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            displayView(i);
        }
    }

    private void displayView(int i) {
        switch (i){
            case 0:

                break;
            case 1:
                startActivity(new Intent(DongxiMainScreenActivity.this,UserSettingsActivity.class));
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        private final String[] titles={
                "发现东西","分类"
        };

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        public MyPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    if(findNewThingFragment ==null){
                        findNewThingFragment =new FindNewThingFragment();
                    }
                    return findNewThingFragment;

                case 1:
                    if(classifiedFragment==null){
                        classifiedFragment=new ClassifiedFragment();
                    }
                    return classifiedFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }




}
