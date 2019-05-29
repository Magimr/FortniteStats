package com.example.fortnitestats.shop;
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


import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    private List<Items> mItemList;
    private LayoutInflater mInflater;
    private Context context;
    public ShopAdapter(Context context, List<Items> itemsList){
        mInflater = LayoutInflater.from(context);
        this.mItemList = itemsList;
        this.context = context;    }
    class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView txtItemName;
        public final TextView txtRarity;
        public final TextView txtItemType;
        public final TextView txtPrice;
        public final ImageView imgItem;
        final ShopAdapter mAdapter;

        public ShopViewHolder(View itemView, ShopAdapter adapter){
            super(itemView);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtRarity = itemView.findViewById(R.id.txtRarity);
            txtItemType = itemView.findViewById(R.id.txtItemType);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgItem = itemView.findViewById(R.id.imgItem);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"PULSADO ELEMENTO NUMERO "+mItemList.get(getLayoutPosition()),Toast.LENGTH_LONG);
        }
    }
    public ShopAdapter() {
        super();
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View mItemView = mInflater
                .inflate(R.layout.items_shop, viewGroup, false);
        return new ShopViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder shopViewHolder, int position) {
        Items mCurrent = mItemList.get(position);
        shopViewHolder.txtItemName.setText((mCurrent.getName()));
        shopViewHolder.txtItemType.setText(mCurrent.getItem().getType());
        shopViewHolder.txtRarity.setText(mCurrent.getItem().getRarity());
        shopViewHolder.txtPrice.setText(mCurrent.getCost());
        Glide.with(context).load(mCurrent.getItem().getImages().getBackground()).into(shopViewHolder.imgItem);


    }

    @Override
    public int getItemCount() {
        if(mItemList == null) {
            return 0;
        }

        return mItemList.size();
    }

    public void setData(List <Items> newList){
        mItemList = newList;
        notifyDataSetChanged();
    }
}
