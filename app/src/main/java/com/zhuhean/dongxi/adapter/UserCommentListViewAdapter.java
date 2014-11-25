package com.zhuhean.dongxi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.model.UserCommentItem;

import java.util.ArrayList;

/**
 * Created by vincent on 14/11/23.
 */
public class UserCommentListViewAdapter extends BaseAdapter {
    ArrayList<UserCommentItem> userCommentItemArrayList=new ArrayList<UserCommentItem>();
    private Context context;

    public UserCommentListViewAdapter(Context context,ArrayList<UserCommentItem> userCommentItemArrayList){
        this.context=context;
        this.userCommentItemArrayList=userCommentItemArrayList;
    }

    @Override
    public int getCount() {
        return userCommentItemArrayList.size()+2;
    }

    @Override
    public Object getItem(int i) {
        return userCommentItemArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView=null;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(i==0){
            rootView=inflater.inflate(R.layout.user_comment_list_view_first_item,viewGroup,false);
        }else if(i==getCount()-1){
            rootView=inflater.inflate(R.layout.user_comment_list_view_last_item,viewGroup,false);
        }else{
            rootView=inflater.inflate(R.layout.user_comment_list_view_item,viewGroup,false);
            ImageView userIconImageView=(ImageView)rootView.findViewById(R.id.user_comment_list_view_user_icon);
            TextView userNameTextView=(TextView)rootView.findViewById(R.id.user_comment_list_view_user_name);
            TextView userCommentTextView=(TextView)rootView.findViewById(R.id.user_comment_list_view_user_comment);

            userIconImageView.setImageResource(userCommentItemArrayList.get(i-1).getUserIcon());
            userNameTextView.setText(userCommentItemArrayList.get(i-1).getUserName());
            userCommentTextView.setText(userCommentItemArrayList.get(i-1).getUserComment());

        }
        return rootView;
    }
}
