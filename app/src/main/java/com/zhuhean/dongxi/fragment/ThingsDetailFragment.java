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
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.zhuhean.dongxi.R;
import com.zhuhean.dongxi.adapter.GuessUserLikesGridViewAdapter;
import com.zhuhean.dongxi.adapter.UserCommentListViewAdapter;
import com.zhuhean.dongxi.model.GuessUserLikesItem;
import com.zhuhean.dongxi.model.UserCommentItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vincent on 14/11/23.
 */
public class ThingsDetailFragment extends Fragment {
    private View rootView;
    private SliderLayout mDemoSlider;
    private GridView guessUserLikesGridView;
    private ListView commentsListView;
    private ArrayList<UserCommentItem> userCommentItemArrayList;
    private ArrayList<GuessUserLikesItem> guessUserLikesItemArrayList;
    private UserCommentListViewAdapter userCommentListViewAdapter;
    private GuessUserLikesGridViewAdapter guessUserLikesGridViewAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_things_item_detail,container,false);
        mDemoSlider=(SliderLayout)rootView.findViewById(R.id.things_item_detail_slider_layout);
        commentsListView=(ListView)rootView.findViewById(R.id.things_item_detail_list_view);
        guessUserLikesGridView=(GridView)rootView.findViewById(R.id.things_item_detail_grid_view);

        guessUserLikesItemArrayList=new ArrayList<GuessUserLikesItem>();
        for(int i=0;i<10;i++) {
            guessUserLikesItemArrayList.add(new GuessUserLikesItem(R.drawable.pic_a, "$" + 23, "life is just fine and I think this is really great", "I don't know what to say"));
        }
        //guessUserLikesItemArrayList.add(new GuessUserLikesItem(R.drawable.pic_b,"$"+45,"Any thing you ever told me will be proud","now I a fat house cat"));
        //guessUserLikesItemArrayList.add(new GuessUserLikesItem(R.drawable.pic_c,"$"+2,"could be better than that","may be a hundred different things inside her shell"));
        //guessUserLikesItemArrayList.add(new GuessUserLikesItem(R.drawable.pic_d,"$"+45,"I just know why you can't not come with me","cause this is not your dream"));
        guessUserLikesGridViewAdapter=new GuessUserLikesGridViewAdapter(getActivity(),guessUserLikesItemArrayList);
        guessUserLikesGridView.setAdapter(guessUserLikesGridViewAdapter);

        userCommentItemArrayList=new ArrayList<UserCommentItem>();
        userCommentItemArrayList.add(new UserCommentItem(R.drawable.duck,"funny bob","this is gonna kick some ass for god's sake"));
        userCommentItemArrayList.add(new UserCommentItem(R.drawable.bird,"angry man","hey,what's up."));
        userCommentListViewAdapter=new UserCommentListViewAdapter(getActivity(),userCommentItemArrayList);
        commentsListView.setAdapter(userCommentListViewAdapter);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mDemoSlider.addSlider(textSliderView);
        }

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
