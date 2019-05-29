package com.example.fortnitestats.upcomingitems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fortnitestats.R;

public class UpcomingItemActivity extends AppCompatActivity implements Controller.ServerResponse{

    UpcomingItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingitem);

        Controller controller = new Controller(this);
        controller.start();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new UpcomingItemAdapter(this);
        recyclerView.setAdapter(adapter);



        LinearLayoutManager manager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(manager);
    }


    @Override
    public void onResponse(UpcomingItem upcomingItem) {
        adapter.setData(upcomingItem.getItems());
    }
}
