package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<History>  historyList;
    ArrayList<Product>  productList = new ArrayList<>();

    ArrayList<Product> restockStore = new ArrayList<>();

    Button buttonOkay, buttonCancel;

    TextView textViewRestock;

    EditText editTextRestock;

    ListView listviewRestock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        buttonCancel = findViewById(R.id.buttonCancel);
        buttonOkay = findViewById(R.id.buttonOkay);
        editTextRestock = findViewById(R.id.editTextRestock);
        textViewRestock = findViewById(R.id.textViewRestock);

        listviewRestock = findViewById(R.id.listviewRestock);

        buttonOkay.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        editTextRestock.setOnClickListener(this);

        historyList = ((MyApp)getApplication()).historyList;

        restockStore = ((MyApp)getApplication()).store;



        ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(restockStore, this);


        listviewRestock.setAdapter(productBaseAdapter);

        // inventory array indices: Pants = 0, Shoes = 1, Hats = 2

        // Populate the listView
//        Product pants = new Product(((MyApp)getApplication()).store.get(0).getProductName(), ((MyApp)getApplication()).inventory[0],
//                ((MyApp)getApplication()).store.get(0).getProductPrice());
//        Product shoes = new Product(((MyApp)getApplication()).store.get(1).getProductName(), ((MyApp)getApplication()).inventory[1],
//                ((MyApp)getApplication()).store.get(1).getProductPrice());
//        Product hats = new Product(((MyApp)getApplication()).store.get(2).getProductName(), ((MyApp)getApplication()).inventory[2],
//                ((MyApp)getApplication()).store.get(2).getProductPrice());
//        productList.add(pants);
//        productList.add(shoes);
//        productList.add(hats);

        restockStore = ((MyApp)getApplication()).store;


        listviewRestock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = (long) parent.getId();
                if (id == R.id.listviewRestock) {

                    // setting the textView to show the product name in the textViewRestock for the
                    // product inventory to be increased
                    textViewRestock.setText(restockStore.get(position).getProductName());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonOkay) {
            if (textViewRestock.getText() == "" || editTextRestock.getText().toString() == "") {
                Toast.makeText(getApplicationContext(), R.string.error_missingProductAndNewQty, Toast.LENGTH_LONG).show();
            }
            else {
                int newQuantity = Integer.parseInt(editTextRestock.getText().toString());

            }
        }
        else if (id == R.id.buttonCancel) {

        }
        else if (id == R.id.editTextRestock) {

        }
    }
}