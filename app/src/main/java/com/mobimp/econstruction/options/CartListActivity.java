package com.mobimp.econstruction.options;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.ArrayItem.ProductCartItem;
import com.mobimp.econstruction.Async.AsyncGetItem_cart;
import com.mobimp.econstruction.Async.AsyncHttp;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.product.ItemDetailsActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.DataUrl;
import com.mobimp.econstruction.utility.ImageUrlUtils;

import java.util.ArrayList;
import java.util.List;

import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_POSITION;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_URI;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_ID;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_TYPE;


public class CartListActivity extends AppCompatActivity implements AsyncGetItem_cart.GetItemTask, AsyncHttp.GetHttpTask {
    private static Context mContext;
    ProgressBar progressBar;
    LinearLayout layoutCartItems;
    LinearLayout layoutCartPayments;
    LinearLayout layoutCartNoItems;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Cart");
        ab.setDisplayHomeAsUpEnabled(true);
        mContext = CartListActivity.this;

        progressBar=(ProgressBar) findViewById(R.id.progressBar_cart);
        layoutCartItems = (LinearLayout) findViewById(R.id.layout_items);
        layoutCartPayments = (LinearLayout) findViewById(R.id.layout_payment);
        layoutCartNoItems = (LinearLayout) findViewById(R.id.layout_cart_empty);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        new AsyncGetItem_cart(mContext, DataUrl.GET_CART_LIST+MainActivity.uid+"&token="+MainActivity.token,CartListActivity.this).execute();
         }

    @Override
    public void GetItemTaskSuccess(List<ProductCartItem> mArray) {
        progressBar.setVisibility(View.GONE);

        if(mArray.size() >0){
            layoutCartNoItems.setVisibility(View.GONE);
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        }else {
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartItems.setVisibility(View.GONE);
            layoutCartPayments.setVisibility(View.GONE);

            Button bStartShopping = (Button) findViewById(R.id.bAddNew);
            bStartShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        RecyclerView.LayoutManager recylerViewLayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(new CartListActivity.SimpleStringRecyclerViewAdapter(recyclerView, mArray));

    }

    @Override
    public void GetItemTaskFailed(String info) {
        Snackbar.make((View)(recyclerView),info,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void GetHttpTaskSuccess(String info) {
        Snackbar.make((View)(recyclerView),info,Snackbar.LENGTH_LONG).show();
        new AsyncGetItem_cart(mContext, DataUrl.GET_CART_LIST+MainActivity.uid+"&token="+MainActivity.token,CartListActivity.this).execute();

    }

    @Override
    public void GetHttpTaskFailed(String info) {
        Snackbar.make((View)(recyclerView),info,Snackbar.LENGTH_LONG).show();
    }

    public class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder> {

        private List<ProductCartItem> mCartList;
        private RecyclerView mRecyclerView;

        public  class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final SimpleDraweeView mImageView;
            public  TextView txtItemName,txtItemDesc,txtItemPrice,txtItemQty,txtItemShippingHanding;
            public final LinearLayout mLayoutItem, mLayoutRemove , mLayoutEdit;
            RelativeLayout SoldOut;
            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (SimpleDraweeView) view.findViewById(R.id.image_cartlist);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item_desc);
                mLayoutRemove = (LinearLayout) view.findViewById(R.id.layout_action_cart_remove);
                mLayoutEdit = (LinearLayout) view.findViewById(R.id.layout_action_cart_edit);
                txtItemName=(TextView) view.findViewById(R.id.txt_cart_item_name);
                txtItemDesc=(TextView) view.findViewById(R.id.txt_cart_item_desc);
                txtItemPrice=(TextView) view.findViewById(R.id.txt_cart_item_price);
                txtItemQty=(TextView) view.findViewById(R.id.txt_cart_qty);
                txtItemShippingHanding=(TextView) view.findViewById(R.id.txt_cart_handing_shipping);
                SoldOut=(RelativeLayout) view.findViewById(R.id.relative_layout_cart_cover);



            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, List<ProductCartItem> mCartList) {
            this.mCartList = mCartList;
            mRecyclerView = recyclerView;
        }

        @Override
        public CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cartlist_item, parent, false);
            return new CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onViewRecycled(CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder) {
            if (holder.mImageView.getController() != null) {
                holder.mImageView.getController().onDetach();
            }
            if (holder.mImageView.getTopLevelDrawable() != null) {
                holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
            }
        }

        @Override
        public void onBindViewHolder(final CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder, final int position) {
            final Uri uri = Uri.parse(mCartList.get(position).ImageUrl);
            holder.mImageView.setImageURI(uri);
            holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                    intent.putExtra(STRING_IMAGE_URI, mCartList.get(position).ImageUrl);
                    intent.putExtra(STRING_ITEM_ID, mCartList.get(position).ItemId);
                    intent.putExtra(STRING_ITEM_TYPE, mCartList.get(position).ItemType);
                    mContext.startActivity(intent);
                }
            });

            holder.txtItemName.setText(mCartList.get(position).ItemName);
            holder.txtItemDesc.setText(mCartList.get(position).ItemDesc);
            holder.txtItemPrice.setText("₹"+mCartList.get(position).ItemPrice);
            holder.txtItemQty.setText("Qty: "+mCartList.get(position).ItemQty);
            holder.txtItemShippingHanding.setText("Handling: ₹"+mCartList.get(position).handling+"\n"+"Shipping: ₹"+mCartList.get(position).Shipping);
           //Set click action
            holder.mLayoutRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AsyncHttp(mContext,DataUrl.REMOVE_ITEM_FROM_CART+MainActivity.uid+"&pid="+mCartList.get(position).ItemId+"&token="+MainActivity.token,CartListActivity.this).execute();

                }
            });

            if(mCartList.get(position).IsActive.equals("0")||mCartList.get(position).IsPublish.equals("0")){
                holder.SoldOut.setVisibility(View.VISIBLE);
                holder.mLayoutEdit.setVisibility(View.GONE);
            }
            //Set click action
            holder.mLayoutEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        @Override
        public int getItemCount() {
            return mCartList.size();
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                finish();
                return super.onOptionsItemSelected(item);

        }
    }
}
