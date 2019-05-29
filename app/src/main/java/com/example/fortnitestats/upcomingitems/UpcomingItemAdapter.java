package com.example.fortnitestats.upcomingitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fortnitestats.R;

import java.util.ArrayList;
import java.util.List;

public class UpcomingItemAdapter extends RecyclerView.Adapter<UpcomingItemAdapter.UpcomingItemViewHolder> {

    Context context;
    List<Items> mItemsList = new ArrayList<>();
    LayoutInflater mInflater;

    public UpcomingItemAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public class UpcomingItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final UpcomingItemAdapter mAdapter;
        public final TextView txtItemName;
        public final TextView txtRarity;
        public final ImageView imgItem;
        public final TextView txtItemType;

        public UpcomingItemViewHolder(@NonNull View itemView, UpcomingItemAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;

            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtRarity = itemView.findViewById(R.id.txtRarity);
            imgItem = itemView.findViewById(R.id.imgItem);
            txtItemType = itemView.findViewById(R.id.txtItemType);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            Toast.makeText(context,"PULSADO ITEM NUMERO "+getAdapterPosition(),Toast.LENGTH_LONG).show();

        }
    }

    public UpcomingItemAdapter() {
        super();
    }

    @NonNull
    @Override
    public UpcomingItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View upComingItemView = mInflater.inflate(R.layout.upcomingitem_item,viewGroup,false);
        return new UpcomingItemViewHolder(upComingItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingItemViewHolder upcomingItemViewHolder, int i) {
        Items mCurrent = mItemsList.get(i);
        upcomingItemViewHolder.txtItemName.setText(mCurrent.getName());
        upcomingItemViewHolder.txtRarity.setText(mCurrent.getItem().getRarity());
        upcomingItemViewHolder.txtItemType.setText(mCurrent.getItem().type);
        Glide.with(context).load(mCurrent.getItem().getImages().getBackground()).into(upcomingItemViewHolder.imgItem);


    }

    @Override
    public int getItemCount() {

        return mItemsList.size();
    }


    public void setData(List<Items> newList){
        mItemsList = newList;
        notifyDataSetChanged();
    }
}
