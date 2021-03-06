package com.mobimp.econstruction.startup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mobimp.econstruction.ArrayItem.AdvertisementItem;
import com.mobimp.econstruction.ArrayItem.CategoryItem;
import com.mobimp.econstruction.Async.AsyncGetAdvertisement;
import com.mobimp.econstruction.Async.AsyncGetCategory;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.utility.DataUrl;

import java.util.ArrayList;
import java.util.List;

public class Splash extends AppCompatActivity implements Animation.AnimationListener, AsyncGetCategory.GetCategoryTask, AsyncGetAdvertisement.GetAdvertiseTask {
    Animation animFadeIn;
    ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
        }
        // load the animation
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_fade_in);
        // set animation listener
        animFadeIn.setAnimationListener(Splash.this);
        // animation for image
        logoView = (ImageView) findViewById(R.id.ImageView_logo);
        // start the animation
        logoView.setVisibility(View.VISIBLE);
        logoView.startAnimation(animFadeIn);
        new AsyncGetCategory(Splash.this, DataUrl.GET_CATEGORY,Splash.this).execute();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //under Implementation
    }

    public void onAnimationEnd(Animation animation) {
        // Start Main Screen

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        //under Implementation
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void GetCategoryTaskSuccess(List<CategoryItem> mArray) {
        CategoryActivity.mArray=mArray;

        new AsyncGetAdvertisement(Splash.this, DataUrl.GET_ADVERTISEMENT,Splash.this).execute();
    }

    @Override
    public void GetCategoryTaskFailed(String info) {
        new AsyncGetCategory(Splash.this, DataUrl.GET_CATEGORY,Splash.this).execute();
    }

    @Override
    public void GetAdvertiseTaskSuccess(List<AdvertisementItem> mArray) {
        MainActivity.mAdvertise=mArray;
        Intent i = new Intent(Splash.this, WelcomeActivity.class);
        startActivity(i);
        this.finish();
    }

    @Override
    public void GetAdvertiseTaskFailed(String info) {
        new AsyncGetAdvertisement(Splash.this, DataUrl.GET_ADVERTISEMENT,Splash.this).execute();
    }
}