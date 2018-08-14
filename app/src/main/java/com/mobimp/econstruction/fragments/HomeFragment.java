package com.mobimp.econstruction.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.RecycleViewArticleAdapter;
import com.mobimp.econstruction.adapter.RecycleViewItemAdapter;
import com.mobimp.econstruction.options.PlaceHolderActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.ImageUrlUtils;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] sampleImages = {"https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
            "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC"};

    CarouselView carouselView;
    RecyclerView mRecycleViewSale,mRecycleViewRent,mRecycleViewArticle;
    TextView Buy,Rent,Categories,ConstructionEquipment,Calculator,DTP,SWM;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
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
        carouselView.setPageCount(sampleImages.length);
        mRecycleViewArticle=(RecyclerView) view.findViewById(R.id.recycle_article);
        mRecycleViewRent=(RecyclerView) view.findViewById(R.id.recycle_rent);
        mRecycleViewSale=(RecyclerView) view.findViewById(R.id.recycle_sales);
        mRecycleViewSale.setNestedScrollingEnabled(false);
        mRecycleViewRent.setNestedScrollingEnabled(false);
        mRecycleViewArticle.setNestedScrollingEnabled(false);
        setupRecyclerView(mRecycleViewRent,1);
        setupRecyclerView(mRecycleViewSale,2);
        setupRecyclerView(mRecycleViewArticle,3);
        Buy=(TextView) view.findViewById(R.id.txt_buy_shortcut);
        Rent=(TextView) view.findViewById(R.id.txt_rent_shortcut);
        Categories=(TextView) view.findViewById(R.id.txt_categories_shortcut);
        ConstructionEquipment=(TextView) view.findViewById(R.id.txt_Construction_equip_shortcut);
        Calculator=(TextView) view.findViewById(R.id.txt_Calculator_shortcut);
        DTP=(TextView) view.findViewById(R.id.txt_design_shortcut);
        SWM=(TextView) view.findViewById(R.id.txt_Solid_shortcut);

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
                startActivity(new Intent(getActivity(), PlaceHolderActivity.class));
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
                    .load(sampleImages[position])
                    .centerCrop()
                    .placeholder(R.drawable.splashscreen_logo)
                    .crossFade()
                    .thumbnail(0.2f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    };

    private void setupRecyclerView(RecyclerView recyclerView,int type) {

        String[] items=null;
        if(type==1) {
            items = ImageUrlUtils.forRent();
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RecycleViewItemAdapter(recyclerView, items,(MainActivity) getActivity()));
        }else if(type==2){
            items = ImageUrlUtils.forsales();
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RecycleViewItemAdapter(recyclerView, items,(MainActivity) getActivity()));
        }else{
            items = ImageUrlUtils.forarticle();
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RecycleViewArticleAdapter(recyclerView, items,(MainActivity) getActivity()));
        }

    }
}
