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

import com.example.testproject.GlideApp;
import com.example.testproject.R;
import com.example.testproject.entities.Coin;
import com.example.testproject.utils.Router;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<Coin> coins;

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_coin_layout, viewGroup, false);
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

        @BindView(R.id.ivCoinIcon) ImageView imageView;
        @BindView(R.id.tvCoinName) TextView tvName;
        @BindView(R.id.tvCoinPrice) TextView tvPrice;

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
            GlideApp.with(context)
                    .load(coin.getImageUrl())
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            String str = String.valueOf(coin.getId());
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            Router.openCoinDetailActivity(context, coin.getId());
        }
    }
}
