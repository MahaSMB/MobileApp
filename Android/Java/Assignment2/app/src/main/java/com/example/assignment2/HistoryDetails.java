package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class HistoryDetails extends AppCompatActivity {

    ArrayList<History> historyList;
    TextView tvHdProductName, tvHdQuantityQty, tvHdPricePrice, tvHdPurchaseDateDate;

    int currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        tvHdProductName = findViewById(R.id.tvHdProductName);
        tvHdQuantityQty = findViewById(R.id.tvHdQuantityQty);
        tvHdPricePrice = findViewById(R.id.tvHdPricePrice);
        tvHdPurchaseDateDate = findViewById(R.id.tvHdPurchaseDateDate);

        historyList =  (ArrayList<History>) getIntent().getSerializableExtra("purchaseHistory");
        currentProduct = ((MyApp)getApplication()).positionOfProduct;

        String productName = historyList.get(currentProduct).getProductName();
        int productQty = historyList.get(currentProduct).getProductQty();
        double productPrice = historyList.get(currentProduct).getProductPrice();
        DecimalFormat df = new DecimalFormat("0.00");
        Date productPurchaseDate = historyList.get(currentProduct).getPurchaseDate();

        tvHdProductName.setText(productName);
        tvHdQuantityQty.setText(String.valueOf(productQty));
        tvHdPricePrice.setText(String.valueOf(df.format(productPrice)));
        tvHdPurchaseDateDate.setText(String.valueOf(productPurchaseDate));


    }
}