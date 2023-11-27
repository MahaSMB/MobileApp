package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {
    ArrayList<Product> arrayListOfProducts;
    Context activityContext;

    ProductBaseAdapter(ArrayList<Product> list, Context context) {
        arrayListOfProducts = list;
        activityContext = context;
    }

    @Override
    public int getCount() {
        return arrayListOfProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListOfProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View productRowView =  LayoutInflater.from(activityContext).inflate(R.layout.product_list_row,
                parent, false);

        TextView productName = productRowView.findViewById(R.id.textViewProductName);
        TextView productPrice = productRowView.findViewById(R.id.textViewProductPrice);
        TextView productQty = productRowView.findViewById(R.id.textViewProductQty);

        productName.setText(arrayListOfProducts.get(position).getProductName());
        // Formatting the product price to two decimal points
        DecimalFormat df = new DecimalFormat("0.00");
        productPrice.setText(String.valueOf(df.format(arrayListOfProducts.get(position).getProductPrice())));
        productQty.setText(String.valueOf(arrayListOfProducts.get(position).getProductQty()));

        return productRowView;
    }
}
