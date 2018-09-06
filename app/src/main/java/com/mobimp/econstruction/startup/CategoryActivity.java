package com.mobimp.econstruction.startup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mobimp.econstruction.ArrayItem.CategoryItem;
import com.mobimp.econstruction.Async.AsyncGetCategory;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.RecycleViewAdapterCategory;
import com.mobimp.econstruction.utility.DataUrl;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements AsyncGetCategory.GetCategoryTask {

    public static List<CategoryItem> mArray;
    RecyclerView recyclerView;
    RecycleViewAdapterCategory adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=(RecyclerView) findViewById(R.id.recycle_Cat);
        adapter=new RecycleViewAdapterCategory(CategoryActivity.this,CategoryActivity.this, mArray);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
       // new AsyncGetCategory(CategoryActivity.this, DataUrl.GET_CATEGORY,CategoryActivity.this).execute();


    }

    @Override
    public void GetCategoryTaskSuccess(List<CategoryItem> mArrays) {
        adapter=new RecycleViewAdapterCategory(CategoryActivity.this,CategoryActivity.this, mArrays);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void GetCategoryTaskFailed(String info) {

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
