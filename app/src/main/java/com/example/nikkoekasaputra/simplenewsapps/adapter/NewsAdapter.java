package com.example.nikkoekasaputra.simplenewsapps.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nikkoekasaputra.simplenewsapps.R;
import com.example.nikkoekasaputra.simplenewsapps.activity.DetailNewsActivity;
import com.example.nikkoekasaputra.simplenewsapps.model.News;

import java.util.List;

/**
 * Created by Nikko Eka Saputra on 12/03/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> listNews;

    public NewsAdapter(Context context, List<News> listNews){
        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = listNews.get(position);
        Glide.with(context)
                .load(news.getImgNews())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imgNews);
        holder.lblTitleNews.setText(news.getTitleNews());
        holder.lblDateNews.setText(news.getDateNews());
        holder.lblAuthorNews.setText(news.getAuthorNews());
        holder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailNewsActivity.class);
                i.putExtra("imgNews", news.getImgNews());
                i.putExtra("titleNews", news.getTitleNews());
                i.putExtra("contentNews", news.getContentNews());
                i.putExtra("dateNews", news.getDateNews());
                i.putExtra("authorNews", news.getAuthorNews());
                i.putExtra("sourceNews", news.getSourceNews());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvNews;
        private ImageView imgNews;
        private TextView lblTitleNews, lblDateNews, lblAuthorNews;

        public ViewHolder(View itemView) {
            super(itemView);

            cvNews = (CardView) itemView.findViewById(R.id.cv_news);
            imgNews = (ImageView) itemView.findViewById(R.id.img_news);
            lblTitleNews = (TextView) itemView.findViewById(R.id.title_news);
            lblDateNews = (TextView) itemView.findViewById(R.id.date_news);
            lblAuthorNews = (TextView) itemView.findViewById(R.id.author_news);
        }
    }
}
