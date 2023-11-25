package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {
    ArrayList<Product>  productArrayList;
    Context activityContext;

    ProductBaseAdapter(ArrayList<Product> list, Context context) {
        productArrayList = list;
        activityContext = context;
    }

    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return productArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View productRowView =  LayoutInflater.from(activityContext).inflate(R.layout.product_list_row,
                parent, false);

        TextView productName = productRowView.findViewById(R.id.textViewProductName);
        TextView productPrice = productRowView.findViewById(R.id.textViewProductPrice);
        TextView productQty = productRowView.findViewById(R.id.textViewProductQty);

        productName.setText(productArrayList.get(position).getProductName());
        productPrice.setText(String.valueOf(productArrayList.get(position).getProductPrice()));
        productQty.setText(String.valueOf(productArrayList.get(position).getProductQty()));

        return productRowView;
    }
}
