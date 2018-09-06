package com.mobimp.econstruction.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobimp.econstruction.ArrayItem.ItemDetails;
import com.mobimp.econstruction.ArrayItem.SearchItemItem;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.options.SearchResultActivity;
import com.mobimp.econstruction.product.ItemDetailsActivity;
import com.mobimp.econstruction.startup.MainActivity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_IMAGE_URI;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_ID;
import static com.mobimp.econstruction.fragments.ProductListFragment.STRING_ITEM_TYPE;

public class SearchListAdapter extends ArrayAdapter<SearchItemItem> {

    private List<SearchItemItem> dataSet;
    Context mContext;
    private static SearchResultActivity mActivity;
    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        SimpleDraweeView ImgView;
        LinearLayout mItemLayout;

    }
    public SearchListAdapter(List<SearchItemItem> data, Context context,SearchResultActivity mActivity) {
        super(context, R.layout.search_list_item, data);
        this.dataSet = data;
        this.mContext=context;
        this.mActivity=mActivity;

    }
    private int lastPosition = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.search_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txt_search_name);
            viewHolder.ImgView = (SimpleDraweeView) convertView.findViewById(R.id.img_list_pro);
            viewHolder.mItemLayout=(LinearLayout) convertView.findViewById(R.id.layout_search);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.txtName.setText(dataSet.get(position).Title);
        Uri uri = Uri.parse(dataSet.get(position).Image);
        viewHolder.ImgView.setImageURI(uri);
        viewHolder.mItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI,dataSet.get(position).Image);
                intent.putExtra(STRING_ITEM_ID, dataSet.get(position).ID);
                intent.putExtra(STRING_ITEM_TYPE, dataSet.get(position).ItemType);
                mActivity.startActivity(intent);
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}