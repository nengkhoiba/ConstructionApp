package com.mobimp.econstruction.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobimp.econstruction.ArrayItem.ItemDetails;
import com.mobimp.econstruction.R;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<ItemDetails> {

    private ArrayList<ItemDetails> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView Desc;

    }

    public ItemListAdapter(ArrayList<ItemDetails> data, Context context) {
        super(context, R.layout.product_details_list_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_details_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txt_detail_title);
            viewHolder.Desc = (TextView) convertView.findViewById(R.id.txt_details_desc);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.txtName.setText(dataSet.get(position).itemtitle);
        viewHolder.Desc.setText(dataSet.get(position).itemdescription);

        // Return the completed view to render on screen
        return convertView;
    }
}