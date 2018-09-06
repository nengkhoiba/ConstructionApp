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
import com.mobimp.econstruction.ArrayItem.ArticleItem;
import com.mobimp.econstruction.R;
import com.mobimp.econstruction.miscellaneous.WebDetailAcivity;
import com.mobimp.econstruction.startup.MainActivity;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleViewArticleAdapter extends RecyclerView.Adapter<RecycleViewArticleAdapter.ViewHolder> {

    private List<ArticleItem> mValues;
    private RecyclerView mRecyclerView;
    private static MainActivity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mImageView;
        public final LinearLayout mLayoutItem;
        public final ImageView mShare;
        public final TextView txtName,txtDesc;

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (SimpleDraweeView) view.findViewById(R.id.img_article);
            mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            mShare = (ImageView) view.findViewById(R.id.ic_article_share);
            txtName=(TextView) view.findViewById(R.id.txt_article_name);
            txtDesc=(TextView) view.findViewById(R.id.txt_article_desc);
        }
    }

    public RecycleViewArticleAdapter(RecyclerView recyclerView, List<ArticleItem> items, MainActivity activity) {
        mValues = items;
        mRecyclerView = recyclerView;
        mActivity = (MainActivity) activity;
    }

    @Override
    public RecycleViewArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new RecycleViewArticleAdapter.ViewHolder(view);
    }


    @Override
    public void onViewRecycled(RecycleViewArticleAdapter.ViewHolder holder) {
        if (holder.mImageView.getController() != null) {
            holder.mImageView.getController().onDetach();
        }
        if (holder.mImageView.getTopLevelDrawable() != null) {
            holder.mImageView.getTopLevelDrawable().setCallback(null);
//                ((BitmapDrawable) holder.mImageView.getTopLevelDrawable()).getBitmap().recycle();
        }
    }

    @Override
    public void onBindViewHolder(final RecycleViewArticleAdapter.ViewHolder holder, final int position) {

        final Uri uri = Uri.parse(mValues.get(position).Image);
        holder.mImageView.setImageURI(uri);
        holder.txtDesc.setText(mValues.get(position).Details);
        holder.txtName.setText(mValues.get(position).Title);

        holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebDetailAcivity.url=mValues.get(position).link;
                Intent newsIntent=new Intent("w2w.web.view");

                v.getContext().startActivity(newsIntent);

            }
        });

        //Set click action for wishlist
        holder.mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "w2w article");
                    String sAux ;
                    sAux =  mValues.get(position).link;
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    mActivity.startActivity(Intent.createChooser(i, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}