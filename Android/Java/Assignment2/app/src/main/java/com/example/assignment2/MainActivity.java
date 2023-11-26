package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.StringKt;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewProductType, textViewTotalPrice, textViewQuantity;
    ListView listViewStore;

    ArrayList<Product> currentStock;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
            button0, buttonClear, buttonBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewProductType = findViewById(R.id.textViewProductType);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        textViewQuantity = findViewById(R.id.textViewQuantity);

        listViewStore = findViewById(R.id.listView);

        currentStock = ((MyApp)getApplication()).store;

        //currentStock = (ArrayList<Product>) getIntent().getSerializableExtra("store");

        ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(currentStock, this);

        listViewStore.setAdapter(productBaseAdapter);

        // Populate the store
        Product pants = new Product("pants", 10, 20.44);
        Product shoes = new Product("shoes", 100, 10.44);
        Product hats = new Product("hats", 30, 5.9);
        currentStock.add(pants);
        currentStock.add(shoes);
        currentStock.add(hats);

        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = (long) view.getId();
                if (id == R.id.textViewProductName) {
                    textViewProductType.setText(currentStock.get(position).getProductName());
                }
                else if (id == R.id.textViewProductPrice) {
                    textViewTotalPrice.setText(String.valueOf(currentStock.get(position).getProductPrice()));
                }
                else if (id == R.id.textViewProductQty) {
                    textViewQuantity.setText(String.valueOf(currentStock.get(position).getProductQty()));
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.error_onItemClickListViewStore, Toast.LENGTH_LONG).show();
                    Log.d("ListViewStore_Error", "You have not clicked on an appropriate section of the store. Please try again!");
                }


            }
        });

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonClear = findViewById(R.id.buttonClear);
        buttonBuy = findViewById(R.id.buttonBuy);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button1) {
            textViewQuantity.append("1");
        }
        else if (id == R.id.button2) {
            textViewQuantity.append("2");
        }
        else if (id == R.id.button3) {
            textViewQuantity.append("3");
        }
        else if (id == R.id.button4) {
            textViewQuantity.append("4");
        }
        else if (id == R.id.button5) {
            textViewQuantity.append("5");
        }
        else if (id == R.id.button6) {
            textViewQuantity.append("6");
        }
        else if (id == R.id.button7) {
            textViewQuantity.append("7");
        }
        else if (id == R.id.button8) {
            textViewQuantity.append("8");
        }
        else if (id == R.id.button9) {
            textViewQuantity.append("9");
        }
        else if (id == R.id.button0) {
            textViewQuantity.append("0");
        }
        else if (id == R.id.buttonClear) {
            clearQuantity();
        }
        else {
            // do nothing
        }
    }

    void clearQuantity() {
        textViewQuantity.setText("");
    }

    void TotalPrice(int amount, double itemPrice) {
        double totalPrice = amount * itemPrice;
        String stringTotalPrice = String.valueOf(totalPrice);
        textViewTotalPrice.setText(stringTotalPrice);
    }


}