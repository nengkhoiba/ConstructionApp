package com.mobimp.econstruction.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.share.widget.ShareDialog;
import com.mobimp.econstruction.ArrayItem.CategoryItem;
import com.mobimp.econstruction.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nengkhoi on 12/04/16.
 */
public class RecycleViewAdapterCategory extends RecyclerView.Adapter<RecycleViewAdapterCategory.MyviewHolder> {


    private LayoutInflater inflater;

    Context context;
    ShareDialog shareDialog;

    List<CategoryItem> data= Collections.emptyList();
private View mView;
    FragmentActivity activity;
    public RecycleViewAdapterCategory(AppCompatActivity activity, Context context, List<CategoryItem> data){
         inflater = LayoutInflater.from(context);
        this.data=data;
        this.context=context;
        this.activity=activity;

    }
    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = inflater.inflate(R.layout.category_item, parent,false);

        MyviewHolder holder=new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyviewHolder holder, final int position) {


        final CategoryItem current=data.get(position);

           Glide
                        .with(holder.mCatImage.getContext())
                        .load(current.ImageUrl)
                        .placeholder(R.drawable.splashscreen_logo)
                        .into(holder.mCatImage);

        holder.mMasterCat.setText(current.MasterCategory);
        holder.mCatName.setText(current.CategoryName);
        holder.mCatId.setText(current.CatID);
        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        public final TextView mCatName,mMasterCat,mCatId;
        public final RelativeLayout mLayoutItem;
        public final ImageView mCatImage;
        public MyviewHolder(View view) {
            super(view);

            mCatName = (TextView) view.findViewById(R.id.txtItemCat);
            mCatId = (TextView) view.findViewById(R.id.txtCatId);
            mMasterCat = (TextView) view.findViewById(R.id.txtMasterCat);
            mLayoutItem = (RelativeLayout) view.findViewById(R.id.item_cat_layout);
            mCatImage = (ImageView) view.findViewById(R.id.imgitemCatImage);

        }
    }


}
