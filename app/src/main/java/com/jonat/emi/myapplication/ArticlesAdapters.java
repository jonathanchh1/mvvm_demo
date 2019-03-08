package com.jonat.emi.myapplication;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonat.emi.myapplication.databinding.ArticleItemsBinding;

import java.util.ArrayList;

public class ArticlesAdapters extends RecyclerView.Adapter<ArticlesAdapters.BinderHolder> {

    private Context mContext;
    private ArrayList<ArticleComment> articles;


    public ArticlesAdapters(Context context, ArrayList<ArticleComment> articles){
        this.mContext = context;
        this.articles = articles;
    }



    @NonNull
    @Override
    public BinderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.article_items, parent, false);

        return new BinderHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BinderHolder binderHolder, int position) {
        ArticleItemsBinding binding = binderHolder.binding;
        binding.setMvm(new ArticleViewModels(articles.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class BinderHolder extends RecyclerView.ViewHolder {

        ArticleItemsBinding binding;
        public BinderHolder(@NonNull ArticleItemsBinding itemView) {
            super(itemView.contactCard);
            this.binding = itemView;
        }
    }
}
