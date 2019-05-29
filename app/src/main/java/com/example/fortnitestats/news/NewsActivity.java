package com.example.fortnitestats.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fortnitestats.R;

public class NewsActivity extends AppCompatActivity implements Controller.ServerResponse{

    NewsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Controller controller = new Controller(this);
        controller.start();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new NewsAdapter(this,null);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onResponse(News news) {
        adapter.setData(news.getData());
    }
}