package com.example.testproject.presentation.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testproject.R;
import com.example.testproject.domain.entities.Coin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<Coin> mCoins;
    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_currency_layout, viewGroup, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder listHolder, int i) {
        String price = String.valueOf(mCoins.get(i).getPrice()) + " $";
        String imageUrl = mCoins.get(i).getImageUrl();
        String name = mCoins.get(i).getName();
        listHolder.bind(imageUrl, name, price);
    }

    @Override
    public int getItemCount() {
        return mCoins != null ? mCoins.size() : 0;
    }

    public void setData(List<Coin> coins) {
        mCoins = coins;
    }

    static class ListHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        @BindView(R.id.iv_currency_icon) ImageView imageView;
        @BindView(R.id.tv_currency_name) TextView tvName;
        @BindView(R.id.tv_currency_price) TextView tvPrice;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bind(String icon, String name, String price) {
            tvName.setText(name);
            tvPrice.setText(price);
            Glide.with(mContext)
                    .load(icon)
                    .into(imageView);
        }
    }
}
