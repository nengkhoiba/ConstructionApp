package com.mobimp.econstruction.product;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.fragments.ProductListFragment;
import com.mobimp.econstruction.fragments.ViewPagerActivity;
import com.mobimp.econstruction.notification.NotificationCountSetClass;
import com.mobimp.econstruction.options.CartListActivity;
import com.mobimp.econstruction.startup.MainActivity;
import com.mobimp.econstruction.utility.ImageUrlUtils;

public class ItemDetailsActivity extends AppCompatActivity {
    int imagePosition;
    String stringImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        SimpleDraweeView mImageView = (SimpleDraweeView)findViewById(R.id.img_productImage);
        TextView textViewAddToCart = (TextView)findViewById(R.id.txt_add_tocart);
        TextView textViewBuyNow = (TextView)findViewById(R.id.txt_buyNow);

        //Getting image uri from previous screen
        if (getIntent() != null) {
            stringImageUri = getIntent().getStringExtra(ProductListFragment.STRING_IMAGE_URI);
            imagePosition = getIntent().getIntExtra(ProductListFragment.STRING_IMAGE_URI,0);
        }
        Uri uri = Uri.parse(stringImageUri);
        mImageView.setImageURI(uri);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(ItemDetailsActivity.this, ViewPagerActivity.class);
                    intent.putExtra("position", imagePosition);
                    startActivity(intent);

            }
        });

        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                Toast.makeText(ItemDetailsActivity.this,"Item added to cart.", Toast.LENGTH_SHORT).show();
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            }
        });

        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
                startActivity(new Intent(ItemDetailsActivity.this, CartListActivity.class));

            }
        });

    }
}
