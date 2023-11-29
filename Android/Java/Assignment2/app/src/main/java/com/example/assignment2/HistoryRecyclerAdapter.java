package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecyclerAdapter extends
        RecyclerView.Adapter<HistoryRecyclerAdapter.HistoryViewHolder> {

    interface HistoryClickListener {
        void onHistoryClicked(int i);
    }

    ArrayList<History> historyList;
    Context context;
    HistoryClickListener listener;
    
    public HistoryRecyclerAdapter(ArrayList<History> historyList, Context context) {
        this.historyList = historyList;
        this.context = context;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_list_row, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        TextView historyProductName = holder.itemView.findViewById(R.id.tvRvProductName);
        TextView historyProductQty = holder.itemView.findViewById(R.id.tvRvProductQty);
        TextView historyProductPrice = holder.itemView.findViewById(R.id.tvRvProductPrice);
        TextView historyProductDate = holder.itemView.findViewById(R.id.tvRvProductDate);

        historyProductName.setText(historyList.get(position).getProductName());
        historyProductQty.setText(historyList.get(position).getProductQty());
        historyProductPrice.setText(String.valueOf(historyList.get(position).getProductPrice()));
        historyProductDate.setText(String.valueOf(historyList.get(position).getPurchaseDate()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onHistoryClicked(holder.getAdapterPosition()); // step 5
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
