package com.mobimp.econstruction.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.ArrayItem.CategoryItem;
import com.mobimp.econstruction.ArrayItem.ProductItem;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.product.ItemDetailsActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.ImageUrlUtils;

import java.util.Collections;
import java.util.List;

import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_POSITION;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_URI;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_ID;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_TYPE;

public class RecycleViewItemAdapter extends RecyclerView.Adapter<RecycleViewItemAdapter.ViewHolder> {

    private List<ProductItem> mValues= Collections.emptyList();
    private RecyclerView mRecyclerView;
    private static MainActivity mActivity;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mImageView;
        public final LinearLayout mLayoutItem;
        public final ImageView mImageViewWishlist;
        public TextView ItemName,itemDesc,ItemPrice,ItemId,ItemType;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (SimpleDraweeView) view.findViewById(R.id.img_product);
            mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            mImageViewWishlist = (ImageView) view.findViewById(R.id.ic_wishlist);
            ItemName=(TextView) view.findViewById(R.id.txt_item_name);
            ItemPrice=(TextView) view.findViewById(R.id.txt_item_price);
            itemDesc=(TextView) view.findViewById(R.id.txt_item_description);
            ItemId=(TextView) view.findViewById(R.id.txt_item_id);
            ItemType=(TextView) view.findViewById(R.id.txt_item_type);


        }
    }

    public RecycleViewItemAdapter(RecyclerView recyclerView, List<ProductItem> items, MainActivity activity) {
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final ProductItem current=mValues.get(position);
        final Uri uri = Uri.parse(current.ImageUrl);
        holder.mImageView.setImageURI(uri);
        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI, current.ImageUrl);
                intent.putExtra(STRING_ITEM_ID, current.ItemId);
                intent.putExtra(STRING_ITEM_TYPE, current.ItemType);
                mActivity.startActivity(intent);

            }
        });
        holder.ItemName.setText(current.ItemName);
        holder.itemDesc.setText(current.ItemDesc);
        holder.ItemPrice.setText("₹"+current.ItemPrice);
        holder.ItemType.setText(current.ItemType);
        holder.ItemId.setText(current.ItemId);

        //Set click action for wishlist
        holder.mImageViewWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addWishlistImageUri(mValues[position]);
                holder.mImageViewWishlist.setImageResource(R.drawable.ic_favorite_black_18dp);
                notifyDataSetChanged();
                //Toast.makeText(mActivity,"Item added to wishlist.", Toast.LENGTH_SHORT).show();*/

            }
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}