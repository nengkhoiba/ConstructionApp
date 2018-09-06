package com.mobimp.econstruction.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mobimp.econstruction.ArrayItem.ProductDetailsItem;
import com.mobimp.econstruction.Async.AsyncGetItemDetails;
import com.mobimp.econstruction.Async.AsyncHttp;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.ItemListAdapter;
import com.mobimp.econstruction.fragments.ProductListFragment;
import com.mobimp.econstruction.fragments.ViewPagerActivity;
import com.mobimp.econstruction.notification.NotificationCountSetClass;
import com.mobimp.econstruction.options.CartListActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.DataUrl;
import com.mobimp.econstruction.utility.ImageUrlUtils;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class ItemDetailsActivity extends AppCompatActivity implements AsyncGetItemDetails.GetItemDetailsTask, AsyncHttp.GetHttpTask {
    int imagePosition;
    String stringImageUri;
    String ItemId;
    String ItemType;
    String Price;
    ScrollView scrollView;
    TextView ItemName,ItemDetails,VendorName,VendorDetails,ItemPrice;
    ListView productdetailsList;
    ProgressBar progressBar;
    LinearLayout layoutBuy,layoutRent;
    CarouselView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Product");
        ab.setDisplayHomeAsUpEnabled(true);
        mImageView = (CarouselView)findViewById(R.id.img_productImage);
        TextView textViewAddToCart = (TextView)findViewById(R.id.txt_add_tocart);
        TextView textViewBuyNow = (TextView)findViewById(R.id.txt_buyNow);

        ItemName=(TextView) findViewById(R.id.txt_item_name);
        ItemDetails=(TextView) findViewById(R.id.txt_extra_details);
        ItemPrice=(TextView) findViewById(R.id.txt_item_price);

        VendorName=(TextView) findViewById(R.id.txt_vendorname);
        VendorDetails=(TextView) findViewById(R.id.txt_vendordetails);

        productdetailsList=(ListView) findViewById(R.id.list_item_details);
        progressBar=(ProgressBar) findViewById(R.id.progressBarDetails);
        layoutBuy=(LinearLayout) findViewById(R.id.linear_buy);
        layoutRent=(LinearLayout) findViewById(R.id.linear_rent);
        scrollView=(ScrollView) findViewById(R.id.scrollbar_details);

        //Getting image uri from previous screen
        if (getIntent() != null) {
            stringImageUri = getIntent().getStringExtra(ProductListFragment.STRING_IMAGE_URI);
            imagePosition = getIntent().getIntExtra(ProductListFragment.STRING_IMAGE_URI,0);
            ItemId=getIntent().getStringExtra(ProductListFragment.STRING_ITEM_ID);
            ItemType=getIntent().getStringExtra(ProductListFragment.STRING_ITEM_TYPE);
        }

        new AsyncGetItemDetails(ItemDetailsActivity.this, DataUrl.GET_ITEM_DETAIL+ItemId,ItemDetailsActivity.this).execute();

        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AsyncHttp(ItemDetailsActivity.this,DataUrl.SET_DATA_CART+MainActivity.uid+"&pid="+ItemId+"&itemtype="+ItemType+"&p="+Price+"&qty=1&token="+MainActivity.token,ItemDetailsActivity.this).execute();

            }
        });

        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncHttp(ItemDetailsActivity.this,DataUrl.SET_DATA_CART+MainActivity.uid+"&pid="+ItemId+"&itemtype="+ItemType+"&p="+Price+"&qty=1&token="+MainActivity.token,ItemDetailsActivity.this).execute();
                startActivity(new Intent(ItemDetailsActivity.this, CartListActivity.class));

            }
        });

    }

    @Override
    public void GetItemdetailsTaskSuccess(final List<ProductDetailsItem> mArray) {

        progressBar.setVisibility(View.GONE);
        scrollView.setVisibility(View.VISIBLE);
        switch (ItemType){
            case "0":
                layoutBuy.setVisibility(View.VISIBLE);
                break;
            case "1":
                layoutRent.setVisibility(View.VISIBLE);
                break;
        }
        Price=mArray.get(0).ItemPrice;
        ItemName.setText(mArray.get(0).ItemName);
        ItemDetails.setText("Handling: ₹"+mArray.get(0).Handling_Charge+", Delivery in: "+mArray.get(0).Delivery_Time+"\n"+mArray.get(0).ItemDesc);
        ItemPrice.setText("₹"+mArray.get(0).ItemPrice);
        VendorName.setText(mArray.get(0).vendorName);
        VendorDetails.setText(mArray.get(0).vendorAbout);
        productdetailsList.setAdapter(new ItemListAdapter(mArray.get(0).Details,ItemDetailsActivity.this));
        //productdetailsList.setScrollContainer(false);
        justifyListViewHeightBasedOnChildren(productdetailsList);
        mImageView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                Glide
                        .with(imageView.getContext())
                        .load(mArray.get(0).Images.get(position).imageUrl)
                        .placeholder(R.color.grey_light)
                        .into(imageView);
            }
        });
        mImageView.setPageCount(mArray.get(0).Images.size());

      mImageView.setImageClickListener(new ImageClickListener() {
          @Override
          public void onClick(int position) {
              ViewPagerActivity.imageUrls=mArray.get(0).Images;
              Intent intent = new Intent(ItemDetailsActivity.this, ViewPagerActivity.class);
              intent.putExtra("position", imagePosition);
              startActivity(intent);
          }
      });
    }

    @Override
    public void GetItemdetailsTaskFailed(String info) {
        progressBar.setVisibility(View.GONE);
        Snackbar.make((View)(ItemName),"Something went wrong",Snackbar.LENGTH_LONG).show();
    }
    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                finish();
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void GetHttpTaskSuccess(String info) {
        Snackbar.make((View)(ItemName),info,Snackbar.LENGTH_LONG).show();
        MainActivity.notificationCountCart++;
        NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
    }

    @Override
    public void GetHttpTaskFailed(String info) {
        Snackbar.make((View)(ItemName),info,Snackbar.LENGTH_LONG).show();
    }
}
