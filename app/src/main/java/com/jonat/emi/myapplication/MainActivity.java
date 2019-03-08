package com.jonat.emi.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.jonat.emi.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.contactList.setLayoutManager(layoutManager);

        ArrayList<Article> articles = new ArrayList<>();

        articles.add(new Article("An outbreak of parasitic bees",
                "This summer, we are facing a very serious issue. And it is nothing else but an outbreak of parasitic bees.",
                true, "android.resource://com.jonat.emi.myapplication/drawable/bee", 45));
        articles.add(new Article("Brno - the city of 2016",
                "It has been announced by the committee of know-it-all that Brno has been elected city of year 2016.",
                true, "android.resource://com.jonat.emi.myapplication/drawable/brno", 0));
        articles.add(new Article("Restaurants in trouble",
                "Restaurants offering daily menus could soon face a serious trouble. The government has just...",
                true, "android.resource://com.jonat.emi.myapplication/drawable/food", 1));
        articles.add(new Article("Survey amongst drivers reveals shocking facts",
                "A survey taken by 1100 drivers commuting every day to work shows that the drivers mostly drive their car alone.",
                true, "android.resource://com.jonat.emi.myapplication/drawable/driver", 33));
        articles.add(new Article("Rugby for everyone?",
                "Until lately, rugby has been considered a sport played only by men. What are the consequences...",
                true, "android.resource://com.jonat.emi.myapplication/drawable/rugby", 11));



        ArticleAdapter mAdapter = new ArticleAdapter(articles, this);
        binding.contactList.setAdapter(mAdapter);


    }






}
