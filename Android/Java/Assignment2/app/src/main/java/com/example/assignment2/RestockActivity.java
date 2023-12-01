package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

        restockStore = ((MyApp)getApplication()).store;

        listviewRestock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = (long) parent.getId();
                if (id == R.id.listviewRestock) {

                    // setting the textView to show the product name in the textViewRestock for the
                    // product inventory to be increased
                    textViewRestock.setText(restockStore.get(position).getProductName());

                    // Saving the position to be used later in the Okay button to restock
                    ((MyApp)getApplication()).positionOfProduct = position;
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

                // Restocking selected product
                int quantityToAdd = Integer.parseInt(editTextRestock.getText().toString());
                int position = ((MyApp)getApplication()).positionOfProduct;
                int oldQuantity = restockStore.get(position).getProductQty();
                int newQuantity = quantityToAdd + oldQuantity;

                restockStore.get(position).setProductQty(newQuantity);
                restartActivity(this);

            }
        }
        else if (id == R.id.buttonCancel) {
            // Return back to the Manager screen
            Intent toManagerIntent = new Intent(this, Manager.class);
            startActivity(toManagerIntent);
        }
//        else if (id == R.id.editTextRestock) {
//
//        }
    }

    public void restartActivity(Activity activity) {
        Intent i = activity.getIntent();
        activity.finish();

        activity.startActivity(i);

        /*
        https://stackoverflow.com/questions/1397361/how-to-restart-activity-in-android
        */
    }
}