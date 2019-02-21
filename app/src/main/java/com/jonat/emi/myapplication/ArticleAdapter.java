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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder>{

  private ArrayList<Article> listArticle;
  private Context context;

    public ArticleAdapter(ArrayList<Article> marticle, MainActivity context) {
        this.listArticle = marticle;
        this.context = context;
    }


    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        ArticleItemsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.article_items, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.BindingHolder bindingHolder, int position) {
        ArticleItemsBinding binding = bindingHolder.binding;
        binding.setMvm(new ArticleViewModel(listArticle.get(position), context));
    }

    @Override
    public int getItemCount() {
        return listArticle.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
        public ArticleItemsBinding binding;
        public BindingHolder(@NonNull ArticleItemsBinding itemView) {
            super(itemView.contactCard);
            this.binding = itemView;
        }
    }
}
