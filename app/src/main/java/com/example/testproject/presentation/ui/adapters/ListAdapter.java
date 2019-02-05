package com.example.testproject.presentation.ui.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.testproject.R;
import com.example.testproject.entities.Coin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<Coin> coins;

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_currency_layout, viewGroup, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder listHolder, int i) {
        listHolder.bind(coins.get(i));
    }

    @Override
    public int getItemCount() {
        return coins != null ? coins.size() : 0;
    }

    public void setData(List<Coin> coins) {
        this.coins = coins;
    }

    static class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context context;
        private Coin coin;

        @BindView(R.id.ivCurrencyIcon) ImageView imageView;
        @BindView(R.id.tvCurrencyName) TextView tvName;
        @BindView(R.id.tvCurrencyPrice) TextView tvPrice;

        ListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
        }

        void bind(Coin coin) {
            this.coin = coin;
            tvName.setText(coin.getName());
            tvPrice.setText(String.valueOf(coin.getPrice()));
            Glide.with(context)
                    .load(coin.getImageUrl())
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
        }
    }
}
