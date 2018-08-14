package com.mobimp.econstruction.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.startup.MainActivity;

public class RecycleViewCategoryAdapter extends RecyclerView.Adapter<RecycleViewCategoryAdapter.ViewHolder> {

    private String[] mValues;
    private RecyclerView mRecyclerView;
    private static MainActivity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mImageView;
        public final LinearLayout mLayoutItem;
        public final ImageView mShare;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (SimpleDraweeView) view.findViewById(R.id.image1);
            mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            mShare = (ImageView) view.findViewById(R.id.ic_share);
        }
    }

    public RecycleViewCategoryAdapter(RecyclerView recyclerView, String[] items, MainActivity activity) {
        mValues = items;
        mRecyclerView = recyclerView;
        mActivity = (MainActivity) activity;
    }

    @Override
    public RecycleViewCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new RecycleViewCategoryAdapter.ViewHolder(view);
    }


    @Override
    public void onViewRecycled(RecycleViewCategoryAdapter.ViewHolder holder) {
        if (holder.mImageView.getController() != null) {
            holder.mImageView.getController().onDetach();
        }
        if (holder.mImageView.getTopLevelDrawable() != null) {
            holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
        }
    }

    @Override
    public void onBindViewHolder(final RecycleViewCategoryAdapter.ViewHolder holder, final int position) {

        final Uri uri = Uri.parse(mValues[position]);
        holder.mImageView.setImageURI(uri);
        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        //Set click action for wishlist
        holder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }
}