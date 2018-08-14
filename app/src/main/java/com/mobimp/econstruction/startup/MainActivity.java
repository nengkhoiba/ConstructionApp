package com.mobimp.econstruction.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.auth.FirebaseAuth;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.fragments.HomeFragment;
import com.mobimp.econstruction.fragments.ProductListFragment;
import com.mobimp.econstruction.fragments.PlaceHolderFragment;
import com.mobimp.econstruction.miscellaneous.EmptyActivity;
import com.mobimp.econstruction.notification.NotificationCountSetClass;
import com.mobimp.econstruction.options.CartListActivity;
import com.mobimp.econstruction.options.PlaceHolderActivity;
import com.mobimp.econstruction.options.SearchResultActivity;
import com.mobimp.econstruction.options.WishlistActivity;
import com.mobimp.econstruction.utility.PrefManager;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int notificationCountCart = 0;
    public static ViewPager viewPager;
    static TabLayout tabLayout;
    TextView signIn,profilename,email;
    CircleImageView imageView;
    LinearLayout profilelayout;
    RelativeLayout Signinlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

         viewPager = (ViewPager) findViewById(R.id.viewpager);
         tabLayout = (TabLayout) findViewById(R.id.tabs);

        if (viewPager != null) {
            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }
        View header = navigationView.getHeaderView(0);
        profilelayout=(LinearLayout) header.findViewById(R.id.linear_layout_profile);
        Signinlayout=(RelativeLayout) header.findViewById(R.id.layout_signin);
        imageView=(CircleImageView) header.findViewById(R.id.profile_image);
        email=(TextView) header.findViewById(R.id.txt_profile_email);
        profilename=(TextView) header.findViewById(R.id.txt_profileName);
        signIn = (TextView) header.findViewById(R.id.txt_signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
        checkLogin();
    }

    public void checkLogin(){
        PrefManager pf =new PrefManager(MainActivity.this);
        if(pf.getBoolDataFromPref("Login")){
            profilelayout.setVisibility(View.VISIBLE);
            Signinlayout.setVisibility(View.GONE);
            profilename.setText(pf.getDataFromPref("Loginname"));
            email.setText(pf.getDataFromPref("Loginemail"));
            Glide
                    .with(this)
                    .load(pf.getDataFromPref("Loginprofile_url"))
                    .centerCrop()
                    .placeholder(R.drawable.splashscreen_logo)
                    .crossFade()
                    .thumbnail(0.2f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }else{
            profilelayout.setVisibility(View.GONE);
            Signinlayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem item = menu.findItem(R.id.action_cart);
        NotificationCountSetClass.setAddToCart(MainActivity.this, item,notificationCountCart);
        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            startActivity(new Intent(MainActivity.this, SearchResultActivity.class));
            return true;
        }else if (id == R.id.action_cart) {

           /* NotificationCountSetClass.setAddToCart(MainActivity.this, item, notificationCount);
            invalidateOptionsMenu();*/
            startActivity(new Intent(MainActivity.this, CartListActivity.class));

           /* notificationCount=0;//clear notification count
            invalidateOptionsMenu();*/
            return true;
        }else {
            startActivity(new Intent(MainActivity.this, EmptyActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        homeFragment.setArguments(bundle);
        adapter.addFragment(homeFragment, getString(R.string.home));
        ProductListFragment fragment = new ProductListFragment();
        bundle = new Bundle();
        bundle.putInt("type", 1);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, getString(R.string.item_1));
        fragment = new ProductListFragment();
        bundle = new Bundle();
        bundle.putInt("type", 2);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, getString(R.string.item_2));

        PlaceHolderFragment pfragment = new PlaceHolderFragment();
        bundle = new Bundle();
        bundle.putInt("type", 3);
        pfragment.setArguments(bundle);
        adapter.addFragment(pfragment, getString(R.string.item_3));
        pfragment = new PlaceHolderFragment();
        bundle = new Bundle();
        bundle.putInt("type", 4);
        pfragment.setArguments(bundle);
        adapter.addFragment(pfragment, getString(R.string.item_4));
        viewPager.setAdapter(adapter);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_item1) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nav_item2) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_item3) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.nav_item4) {
            viewPager.setCurrentItem(4);
        }else if (id == R.id.my_wishlist) {
            startActivity(new Intent(MainActivity.this, WishlistActivity.class));

        }else if (id==R.id.nav_item6) {
            startActivity(new Intent(MainActivity.this, PlaceHolderActivity.class));
        }else if(id==R.id.nav_logout){
            FirebaseAuth mAuth;
            mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();
            PrefManager pf=new PrefManager(MainActivity.this);
            pf.setLogout();
            checkLogin();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
