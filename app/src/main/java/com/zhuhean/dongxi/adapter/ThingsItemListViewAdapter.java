package com.zhuhean.dongxi.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.activity.AdvertiseActivity;
import com.zhuhean.dongxi.activity.DouListActivity;
import com.zhuhean.dongxi.activity.ThingsItemDetailActivity;
import com.zhuhean.dongxi.model.RecommandDouListItem;
import com.zhuhean.dongxi.model.ThingsItem;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vincent on 14/11/22.
 */
public class ThingsItemListViewAdapter extends BaseAdapter {
    private ArrayList<ThingsItem> thingsItemArrayList;
    private ArrayList<RecommandDouListItem> douListItemArrayList;
    private Context context;
    private HashMap<String,Bitmap> mainPictureMap;
    private ImageView mainPictureImageView,userIconImageView;
    private ImageView firstImageView,secondImageView,thirdImageView,forthImageView;


    public ProgressBar progressBar;

    public ThingsItemListViewAdapter(Context context, ArrayList<ThingsItem> list,ArrayList<RecommandDouListItem> douList){
        this.context=context;
        thingsItemArrayList=list;
        douListItemArrayList=douList;
        mainPictureMap=new HashMap<String, Bitmap>();
    }

    @Override
    public int getCount() {
        return thingsItemArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return thingsItemArrayList.get(i-1);

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View rootView;
        if(i==0){
            TextView firstTextView,secondTextView,thirdTextView,forthTextView;

            rootView=inflater.inflate(R.layout.first_item_of_list_view,viewGroup,false);

            firstImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_list_first_item_first_image);
            secondImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_list_first_item_second_image);
            thirdImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_list_first_item_third_image);
            forthImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_list_first_item_forth_image);


            firstTextView=(TextView)rootView.findViewById(R.id.find_new_thing_list_first_item_first_text);
            secondTextView=(TextView)rootView.findViewById(R.id.find_new_thing_list_first_item_second_text);
            thirdTextView=(TextView)rootView.findViewById(R.id.find_new_thing_list_first_item_third_text);
            forthTextView=(TextView)rootView.findViewById(R.id.find_new_thing_list_first_item_forth_text);



            firstTextView.setText(douListItemArrayList.get(0).getDouListTitle());
            secondTextView.setText(douListItemArrayList.get(1).getDouListTitle());
            thirdTextView.setText(douListItemArrayList.get(2).getDouListTitle());
            forthTextView.setText("kindle/拍立得");

            new DownloadDoulistImage().execute(douListItemArrayList.get(0).getDouListImage(),
                    douListItemArrayList.get(1).getDouListImage(),
                    douListItemArrayList.get(2).getDouListImage(),
                    "http://img3.douban.com/view/commodity_story/imedium/public/p11189951.jpg"
                    );

            //"img3.douban.com/view/commodity_story/imedium/public/p11189951.jpg"

            firstImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, DouListActivity.class));
                }
            });
            secondImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ThingsItemDetailActivity.class));
                }
            });
            thirdImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            forthImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, AdvertiseActivity.class));
                }
            });

        }else{

            TextView thingsNameTextView,priceTextView,userNameTextView,userCommentTextView,
                    numberOfLikesTextView,numberOfAddToDouListTextView,numberOfReplyTextView;

            rootView=inflater.inflate(R.layout.find_new_thing_item,viewGroup,false);
            progressBar=(ProgressBar)rootView.findViewById(R.id.find_new_thing_item_progress_bar);
            mainPictureImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_item_main_image);
            userIconImageView=(ImageView)rootView.findViewById(R.id.find_new_thing_item_user_icon);
            thingsNameTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_name);
            priceTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_price);
            userNameTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_user_name);
            userCommentTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_user_comment);
            numberOfLikesTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_number_of_likes);
            numberOfAddToDouListTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_number_of_add_to_dou_list);
            numberOfReplyTextView=(TextView)rootView.findViewById(R.id.find_new_thing_item_number_of_reply);
            new DownloadItemImage().execute(thingsItemArrayList.get(i-1).getMainPicture());
            new DownloadIcon().execute(thingsItemArrayList.get(i-1).getUserIcon());
            thingsNameTextView.setText(thingsItemArrayList.get(i-1).getThingsName());
            priceTextView.setText(thingsItemArrayList.get(i-1).getPrice());
            userNameTextView.setText(thingsItemArrayList.get(i-1).getUserName());
            userCommentTextView.setText(thingsItemArrayList.get(i-1).getUserComment());
            if(thingsItemArrayList.get(i-1).getNumberOfLikes().indexOf("喜欢")>=0){
                numberOfLikesTextView.setText(thingsItemArrayList.get(i-1).getNumberOfLikes());
            }else {
                numberOfLikesTextView.setText("喜欢 0");
            }
            if(thingsItemArrayList.get(i-1).getNumberOfAddToDouList().indexOf("加入豆列")>=0){
                numberOfAddToDouListTextView.setText(thingsItemArrayList.get(i-1).getNumberOfAddToDouList());
            }else {
                numberOfAddToDouListTextView.setText("加入豆列0");
            }
            if(thingsItemArrayList.get(i-1).getNumberOfReply().indexOf("评论")>=0){
                numberOfReplyTextView.setText(thingsItemArrayList.get(i-1).getNumberOfReply());
            }else{
                numberOfReplyTextView.setText("评论 0");
            }

        }
        return rootView;
    }

    private class DownloadDoulistImage extends AsyncTask<String,Bitmap,Void>{
        ArrayList<Bitmap> bitmapArrayList;

        private int i=0;

        public DownloadDoulistImage(){
            bitmapArrayList=new ArrayList<Bitmap>();
        }

        @Override
        protected Void doInBackground(String... strings) {
                for (int i = 0; i < strings.length; i++) {
                    try {
                        InputStream inputStream;
                        inputStream = new URL(strings[i]).openStream();
                        Bitmap itemImage = BitmapFactory.decodeStream(inputStream);
                        mainPictureMap.put(strings[i], itemImage);
                        bitmapArrayList.add(itemImage);
                        publishProgress(itemImage);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                        e.printStackTrace();
                    }
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Bitmap... bitmap) {
            if(i==0) {
                firstImageView.setImageBitmap(bitmap[0]);
            }else if(i==1) {
                secondImageView.setImageBitmap(bitmap[0]);
            }else if(i==2) {
                thirdImageView.setImageBitmap(bitmap[0]);
            }else {
                forthImageView.setImageBitmap(bitmap[0]);
            }
            i++;
        }

        @Override
        protected void onPreExecute() {
            firstImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            secondImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            thirdImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            forthImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

    }

    private class DownloadItemImage extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            String imageUrl=strings[0];
            Bitmap itemImage=null;
            if(mainPictureMap.containsKey(imageUrl)){
                return mainPictureMap.get(imageUrl);
            }
            try {
                InputStream inputStream;
                inputStream = new URL(imageUrl).openStream();
                itemImage= BitmapFactory.decodeStream(inputStream);
                mainPictureMap.put(imageUrl,itemImage);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return itemImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressBar.setVisibility(View.GONE);
            mainPictureImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mainPictureImageView.setImageBitmap(bitmap);
        }

    }

    private class DownloadIcon extends DownloadItemImage{
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            userIconImageView.setImageBitmap(bitmap);
        }
    }

}
