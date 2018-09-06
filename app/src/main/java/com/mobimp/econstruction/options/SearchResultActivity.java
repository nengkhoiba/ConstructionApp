package com.mobimp.econstruction.options;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobimp.econstruction.ArrayItem.SearchItemItem;
import com.mobimp.econstruction.Async.AsyncGetSearch;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.adapter.SearchListAdapter;
import com.mobimp.econstruction.utility.DataUrl;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class SearchResultActivity extends AppCompatActivity implements AsyncGetSearch.GetSearchTask {
    ListView searchResult;
    TextView txtResult;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Search");
        ab.setDisplayHomeAsUpEnabled(true);
        searchResult=(ListView) findViewById(R.id.listview_search);
        progressBar=(ProgressBar) findViewById(R.id.progressbar_search);
        txtResult=(TextView) findViewById(R.id.txt_search_message);
        handleIntent(getIntent());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.getItem(0);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(View.VISIBLE);
                txtResult.setVisibility(View.GONE);
                new AsyncGetSearch(SearchResultActivity.this, DataUrl.SEARCH_ITEM+newText,SearchResultActivity.this).execute();
                return true;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish();
                return true;
            }
        });
        searchView.setFocusable(true);
        searchItem.expandActionView();
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            new AsyncGetSearch(SearchResultActivity.this, DataUrl.SEARCH_ITEM+query,SearchResultActivity.this).execute();
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

    @Override
    public void GetSearchTaskSuccess(List<SearchItemItem> mArray) {

        progressBar.setVisibility(View.GONE);
        txtResult.setVisibility(View.GONE);
        searchResult.setAdapter(new SearchListAdapter(mArray,SearchResultActivity.this,SearchResultActivity.this));
    }

    @Override
    public void GetSearchTaskFailed(String info) {
        progressBar.setVisibility(View.GONE);
        txtResult.setVisibility(View.VISIBLE);
        List<SearchItemItem> mArray=new ArrayList<SearchItemItem>();
        searchResult.setAdapter(new SearchListAdapter(mArray,SearchResultActivity.this,SearchResultActivity.this));

    }
}
