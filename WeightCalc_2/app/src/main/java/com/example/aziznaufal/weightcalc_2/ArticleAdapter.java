package com.example.aziznaufal.weightcalc_2;
import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aziz Naufal on 1/6/2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private Context context;
    private List<HealthyArticle> list;

    public ArticleAdapter(Context context, List<HealthyArticle> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HealthyArticle article = list.get(position);

        holder.snippet.setText(String.valueOf(article.getsnippet()));
        holder.url.setText(String.valueOf(article.getWeb_url()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        public TextView snippet, url;
        public ViewHolder(View itemView){
            super(itemView);

            snippet = (TextView) itemView.findViewById(R.id.snippet);
            url = (TextView) itemView.findViewById(R.id.url);
        }
    }
}
