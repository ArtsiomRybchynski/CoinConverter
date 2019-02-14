package com.example.testproject.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testproject.GlideApp;
import com.example.testproject.R;
import com.example.testproject.entities.Coin;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterListAdapter extends RecyclerView.Adapter<FilterListAdapter.FilterListHolder> {

    private List<Coin> coins;

    @NonNull
    @Override
    public FilterListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_coin_filter_layout, parent, false);
        return new FilterListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterListHolder holder, int position) {
        holder.bind(coins.get(position));
    }

    @Override
    public int getItemCount() {
        return coins != null ? coins.size() : 0;
    }

    public void setData(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getChangedData() {
        return coins;
    }

    public void setChecked(boolean isChecked) {
        for (Coin coin : coins) {
            coin.setNotShown(!isChecked);
        }
        notifyDataSetChanged();
    }

    static class FilterListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context context;
        private Coin coin;

        @BindView(R.id.ivCoinIconFilter)
        ImageView ivCoinIcon;

        @BindView(R.id.tvCoinNameFilter)
        TextView tvName;

        @BindView(R.id.checkBoxFilter)
        CheckBox checkBox;

        FilterListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
            checkBox.setClickable(false);
        }

        void bind(Coin coin) {
            this.coin = coin;

            tvName.setText(coin.getName());
            checkBox.setChecked(!coin.isNotShown());
            GlideApp.with(context)
                    .load(coin.getImageUrl())
                    .onlyRetrieveFromCache(true)
                    .into(ivCoinIcon);
        }

        @Override
        public void onClick(View v) {
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                coin.setNotShown(true);
            }
            else {
                checkBox.setChecked(true);
                coin.setNotShown(false);
            }
        }
    }
}
