package com.mobimp.econstruction.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mobimp.econstruction.ArrayItem.ArticleItem;
import com.mobimp.econstruction.ArrayItem.ProductItem;
import com.mobimp.econstruction.Async.AsyncGetArticle;
import com.mobimp.econstruction.Async.AsyncGetItem;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.RecycleViewArticleAdapter;
import com.mobimp.econstruction.adapter.RecycleViewItemAdapter;
import com.mobimp.econstruction.options.PlaceHolderActivity;
import com.mobimp.econstruction.startup.CategoryActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.DataUrl;
import com.mobimp.econstruction.utility.ImageUrlUtils;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements AsyncGetItem.GetItemTask, AsyncGetArticle.GetArticleTask {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CarouselView carouselView;
    RecyclerView mRecycleViewSale,mRecycleViewRent,mRecycleViewArticle;
    TextView Buy,Rent,Categories,ConstructionEquipment,Calculator,DTP,SWM,RentMore,saleMore,articleMore;
    ProgressBar progressRent,progressSales,ProgressArticle;
    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(MainActivity.mAdvertise.size());
        mRecycleViewArticle=(RecyclerView) view.findViewById(R.id.recycle_article);
        mRecycleViewRent=(RecyclerView) view.findViewById(R.id.recycle_rent);
        mRecycleViewSale=(RecyclerView) view.findViewById(R.id.recycle_sales);
        mRecycleViewSale.setNestedScrollingEnabled(false);
        mRecycleViewRent.setNestedScrollingEnabled(false);
        mRecycleViewArticle.setNestedScrollingEnabled(false);

        progressRent=(ProgressBar) view.findViewById(R.id.progressBarRent);
        progressSales=(ProgressBar) view.findViewById(R.id.progressBarSales);
        ProgressArticle=(ProgressBar) view.findViewById(R.id.progressBarArticle);
        setupRecyclerView(mRecycleViewRent,1,progressRent);
        setupRecyclerView(mRecycleViewSale,2,progressSales);
        setupRecyclerView(mRecycleViewArticle,3,ProgressArticle);


        Buy=(TextView) view.findViewById(R.id.txt_buy_shortcut);
        Rent=(TextView) view.findViewById(R.id.txt_rent_shortcut);
        RentMore=(TextView) view.findViewById(R.id.txt_for_rent_more);
        saleMore=(TextView) view.findViewById(R.id.txt_for_sale_more);
        articleMore=(TextView) view.findViewById(R.id.txt_article_more);

        Categories=(TextView) view.findViewById(R.id.txt_categories_shortcut);
        ConstructionEquipment=(TextView) view.findViewById(R.id.txt_Construction_equip_shortcut);
        Calculator=(TextView) view.findViewById(R.id.txt_Calculator_shortcut);
        DTP=(TextView) view.findViewById(R.id.txt_design_shortcut);
        SWM=(TextView) view.findViewById(R.id.txt_Solid_shortcut);

        saleMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(1);
            }
        });
        RentMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(2);
            }
        });
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(1);
            }
        });
        Rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(2);
            }
        });
        Categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CategoryActivity.class));
            }
        });
        ConstructionEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(3);
            }
        });
        Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlaceHolderActivity.class));
            }
        });
        DTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlaceHolderActivity.class));
            }
        });
        SWM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewPager.setCurrentItem(4);
            }
        });
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Glide
                    .with(HomeFragment.this)
                    .load(MainActivity.mAdvertise.get(position).Image)
                    .placeholder(R.color.grey_light)
                    .into(imageView);

        }
    };

    private void setupRecyclerView(RecyclerView recyclerView, int type, ProgressBar progressBar) {


        String[] items=null;
        if(type==1) {
            String url = DataUrl.GET_ITEM+10+"&c="+0+"&n="+""+"&p="+1;
            new AsyncGetItem(getActivity().getApplicationContext(), url,HomeFragment.this,progressBar,recyclerView).execute();

        }else if(type==2){
            String url = DataUrl.GET_ITEM+9+"&c="+0+"&n="+""+"&p="+1;
            new AsyncGetItem(getActivity().getApplicationContext(), url,HomeFragment.this,progressBar,recyclerView).execute();
        }else{
            String url = DataUrl.GET_ARTICLE+1;
            new AsyncGetArticle(getActivity().getApplicationContext(), url,HomeFragment.this,progressBar,recyclerView).execute();

            }

    }


    @Override
    public void GetItemTaskSuccess(List<ProductItem> mArray, ProgressBar progressBar, RecyclerView recyclerView) {
        progressBar.setVisibility(View.GONE);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecycleViewItemAdapter(recyclerView, mArray,(MainActivity) getActivity()));

    }

    @Override
    public void GetItemTaskFailed(String info, ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void GetArticleTaskSuccess(List<ArticleItem> mArray, ProgressBar progressBar, RecyclerView recyclerView) {
        progressBar.setVisibility(View.GONE);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecycleViewArticleAdapter(recyclerView, mArray,(MainActivity) getActivity()));

    }

    @Override
    public void GetArticleTaskFailed(String info, ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);

    }
}
