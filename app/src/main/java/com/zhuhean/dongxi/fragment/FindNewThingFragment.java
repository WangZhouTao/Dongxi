package com.zhuhean.dongxi.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.adapter.ThingsItemListViewAdapter;
import com.zhuhean.dongxi.library.widget.PullRefreshLayout;
import com.zhuhean.dongxi.model.RecommandDouListItem;
import com.zhuhean.dongxi.model.ThingsItem;
import com.zhuhean.dongxi.utils.MyToast;
import com.zhuhean.dongxi.utils.NetworkChecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vincent on 14/11/21.
 */
public class FindNewThingFragment extends android.support.v4.app.Fragment {
    private PullRefreshLayout pullRefreshLayout;
    private ProgressBar progressBar;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_found_new_thing,container,false);
        pullRefreshLayout=(PullRefreshLayout)view.findViewById(R.id.frame_container_refresh_layout);
        listView=(ListView)view.findViewById(R.id.things_item_list_view);
        progressBar=(ProgressBar)view.findViewById(R.id.things_item_progress_bar);
        //new LoadDongxiData().execute();
        loadListItem();

        setFreshLayout();

        return view;
    }

    private void loadListItem(){
       if(new NetworkChecker(getActivity()).isOnline()) {
         new LoadDongxiData().execute();
        }else {
            MyToast.showLong(getActivity(), "我怀疑你的网络有问题！！");
        }

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                return true;
            case R.id.action_refresh:
                pullRefreshLayout.setRefreshing(true);
                loadListItem();
                pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                    }
                },1000);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setFreshLayout(){
        pullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                loadListItem();
                pullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout.setRefreshing(false);
                    }
                },1000);

            }

        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private class LoadDongxiData extends AsyncTask<Void,Void,Void> {
        private ArrayList<ThingsItem> arrayList;
        private ArrayList<RecommandDouListItem> douListItemArrayList;

        public LoadDongxiData(){
            arrayList=new ArrayList<ThingsItem>();
            douListItemArrayList=new ArrayList<RecommandDouListItem>();
        }

        private void addDataToArrayList(Elements cards) {
            for (Element card : cards) {
                String hdCard = card.getElementsByClass("card-hd").toString();
                int startPosition = hdCard.indexOf("href=");
                int endPosition = hdCard.indexOf("\"", startPosition + 7);
                String itemDetailLink = hdCard.substring(startPosition + 6, endPosition);

                startPosition = hdCard.indexOf("title=", endPosition + 1);
                endPosition = hdCard.indexOf("\"", startPosition + 10);
                String itemName = hdCard.substring(startPosition + 7, endPosition);

                startPosition = hdCard.indexOf("src=", endPosition + 1);
                endPosition = hdCard.indexOf("\"", startPosition + 10);
                String itemImageUrl = hdCard.substring(startPosition + 5, endPosition);

                startPosition = hdCard.indexOf("commodity-price", endPosition + 1);
                endPosition = hdCard.indexOf("span", startPosition + 10);
                String price = hdCard.substring(startPosition + 17, endPosition - 2);

                String author = card.getElementsByClass("author-avatar-link").toString();

                startPosition = author.indexOf("href=");
                endPosition = author.indexOf("\"", startPosition + 7);
                String userHomePageLink = author.substring(startPosition + 6, endPosition);

                startPosition = author.indexOf("src=", endPosition + 1);
                endPosition = author.indexOf("\"", startPosition + 7);
                String userIconUrl = author.substring(startPosition + 5, endPosition);

                startPosition = author.indexOf("title=", endPosition + 1);
                endPosition = author.indexOf("\"", startPosition + 8);
                String userName = author.substring(startPosition + 7, endPosition);

                String userComment = card.getElementsByClass("quote").text();

                String numberOfAddDouToList = card.getElementsByClass("doulist-count").text();
                String numberOfLikes = card.getElementsByClass("like").text();
                String numberOfReply = card.getElementsByClass("post").text();

                arrayList.add(new ThingsItem(itemImageUrl, itemName, price, userIconUrl, userName, userComment, numberOfLikes, numberOfAddDouToList, numberOfReply, userHomePageLink, itemDetailLink));

            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Document document=null;
            Elements cards=null;
            Elements douLists=null;

            try {
                document = Jsoup.connect("http://dongxi.douban.com/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            cards = document.getElementsByClass("card-main");
            addDataToArrayList(cards);

            douLists=document.getElementsByClass("user-doulist-item");
            addToDouList(douLists);

            return null;
        }

        private void addToDouList(Elements douLists) {
            for(int i=0;i<douLists.size();i++){
                String douListContent=douLists.get(i).toString();
                int start=douListContent.indexOf("href=");
                int end=douListContent.indexOf("\"",start+7);
                String douListUrl=douListContent.substring(start+6,end);

                start=douListContent.indexOf("src=",end+3);
                end=douListContent.indexOf("\"",start+6);
                String douListImage=douListContent.substring(start+5,end);

                start=douListContent.indexOf("title=",end+3);
                end=douListContent.indexOf("\"",start+9);
                String douListTitle=douListContent.substring(start+7,end);

                douListItemArrayList.add(new RecommandDouListItem(douListUrl,douListImage,douListTitle));
            }
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.GONE);
            ThingsItemListViewAdapter adapter=new ThingsItemListViewAdapter(getActivity(),arrayList,douListItemArrayList);
            listView.setAdapter(adapter);
        }
    }


}
