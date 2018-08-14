package com.mobimp.econstruction.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.product.ItemDetailsActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.ImageUrlUtils;

import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_POSITION;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_URI;

public class RecycleViewItemAdapter extends RecyclerView.Adapter<RecycleViewItemAdapter.ViewHolder> {

    private String[] mValues;
    private RecyclerView mRecyclerView;
    private static MainActivity mActivity;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mImageView;
        public final LinearLayout mLayoutItem;
        public final ImageView mImageViewWishlist;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (SimpleDraweeView) view.findViewById(R.id.image1);
            mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            mImageViewWishlist = (ImageView) view.findViewById(R.id.ic_wishlist);
        }
    }

    public RecycleViewItemAdapter(RecyclerView recyclerView, String[] items,MainActivity activity) {
        mValues = items;
        mRecyclerView = recyclerView;
        mActivity=(MainActivity) activity;
    }

    @Override
    public RecycleViewItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RecycleViewItemAdapter.ViewHolder(view);
    }


    @Override
    public void onViewRecycled(ViewHolder holder) {
        if (holder.mImageView.getController() != null) {
            holder.mImageView.getController().onDetach();
        }
        if (holder.mImageView.getTopLevelDrawable() != null) {
            holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Uri uri = Uri.parse(mValues[position]);
        holder.mImageView.setImageURI(uri);
        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI, mValues[position]);
                intent.putExtra(STRING_IMAGE_POSITION, position);
                mActivity.startActivity(intent);

            }
        });

        //Set click action for wishlist
        holder.mImageViewWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addWishlistImageUri(mValues[position]);
                holder.mImageViewWishlist.setImageResource(R.drawable.ic_favorite_black_18dp);
                notifyDataSetChanged();
                //Toast.makeText(mActivity,"Item added to wishlist.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }
}