/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobimp.econstruction.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.ArrayItem.CategoryItem;
import com.mobimp.econstruction.ArrayItem.ProductItem;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.EndlessScrollAdapter;
import com.mobimp.econstruction.adapter.RecycleViewItemAdapter;
import com.mobimp.econstruction.product.ItemDetailsActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.DataUrl;
import com.mobimp.econstruction.utility.ImageUrlUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProductListFragment extends Fragment {

    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";
    public static final String STRING_ITEM_ID = "ItemId";
    public static final String STRING_ITEM_TYPE = "ItemType";
    public static final String TAG="Item";
    SwipeRefreshLayout swipeLayout;
    StaggeredGridLayoutManager layoutManager;
    private RecyclerView recylerView;
    private RecycleViewItemAdapter adapter;
    ProgressBar progressBar;
    private List<ProductItem> feedsList = new ArrayList<>();
    static int page = 1;
    int endPosition;
    static int pos;
    public static int masterCat;
    public static String category="0";
    public static String name="";
    private static MainActivity mActivity;
    EndlessScrollAdapter scrollListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_recylerview_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recylerView=(RecyclerView) view.findViewById(R.id.recyclerview_product);
        swipeLayout=(SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayoutSearch);
        recylerView.setLayoutManager(layoutManager);
     //   recylerView.setItemViewCacheSize(6);
        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);
        masterCat=ProductListFragment.this.getArguments().getInt("type");
        searchProduct();
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {


                // our swipeRefreshLayout needs to be notified when the data is returned in order for it to stop the animation
                searchProduct();
                swipeLayout.setRefreshing(false);
            }
        });
        scrollListener =new EndlessScrollAdapter(
                layoutManager) {
            @Override
            public void onLoadMore(int current_page, int totalItemsCount, RecyclerView view) {
                if (current_page > page) {
                    final String url = DataUrl.GET_ITEM+masterCat+"&c="+category+"&n="+name+"&p="+current_page;
                    new AsyncHttpTaskLoadMore().execute(url);
                    page = current_page;
                }
            }


        };

    }

    //////

    void searchProduct() {
        if (feedsList.size()>0) {
            feedsList.clear();
            adapter.notifyDataSetChanged();
            page=1;
           // scrollListener.resetValues();
            Log.d(TAG,"Refresh hit");
            final String url = DataUrl.GET_ITEM+masterCat+"&c="+category+"&n="+name+"&p="+page;
            new AsyncHttpTask().execute(url);
            Log.d(TAG,"Refresh---"+ url);
            swipeLayout.setRefreshing(false);
            // Stop refresh animation
        } else {

            final String url = DataUrl.GET_ITEM+masterCat+"&c="+category+"&n="+name+"&p="+page;
            new AsyncHttpTask().execute(url);
            swipeLayout.setRefreshing(false);
        }
        swipeLayout.setRefreshing(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        masterCat=ProductListFragment.this.getArguments().getInt("type");
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            mActivity.setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            String URL = params[0];
            URL = URL.replaceAll("\n", "%0D%0A");
            URL = URL.replaceAll(" ", "%20");
            HttpURLConnection urlConnection;
            try {
                java.net.URL url = new URL(URL);
                  Log.d(TAG, "--------" + url);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    Log.d(TAG, response.toString());
                    parseResult(response.toString());

                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
                //Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            progressBar.setVisibility(View.GONE);

            if (result == 1) {
                adapter = new RecycleViewItemAdapter(recylerView, feedsList,mActivity);
                recylerView.setAdapter(adapter);
                recylerView.setOnScrollListener(scrollListener) ;

            } else {

            }
            swipeLayout.setRefreshing(false);
        }
    }

    public class AsyncHttpTaskLoadMore extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            String URL = params[0];
            URL = URL.replaceAll("\n", "%0D%0A");
            URL = URL.replaceAll(" ", "%20");
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(URL);
                Log.d(TAG, "--------" + url);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    result= parseResult(response.toString());
                    Log.d(TAG, "--------" + response);
                    // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            progressBar.setVisibility(View.GONE);

            if (result == 1) {
                adapter = new RecycleViewItemAdapter(recylerView, feedsList,mActivity);
                recylerView.setAdapter(adapter);
                recylerView.setOnScrollListener(scrollListener) ;

            } else {

            }
            swipeLayout.setRefreshing(false);
        }
    }

    private int parseResult(String result) {
        int flag=0;


        try {
            JSONObject jsonObj = new JSONObject(result);
            // Getting JSON Array nodel
            String status = jsonObj.getString("success");
            //JSONArray classNameArray = jsonObj.getJSONArray("sectionName");
            if(status.equals("true"))
            {

                JSONArray CategoryArray = jsonObj.getJSONArray("output");
                for(int i=0;i<CategoryArray.length();i++){
                    JSONObject cat = CategoryArray.optJSONObject(i);
                    ProductItem mItem=new ProductItem();
                    mItem.ItemId=cat.optString("ID");
                    mItem.ItemName=cat.optString("ItemName");
                    mItem.ItemDesc=cat.optString("ItemDesc");
                    mItem.ItemPrice=cat.optString("ItemPrice");
                    mItem.ImageUrl=cat.optString("ItemImage");
                    mItem.ItemType=cat.optString("ItemType");
                    feedsList.add(mItem);
                }
                flag=1;

            }else{

                flag=0;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
