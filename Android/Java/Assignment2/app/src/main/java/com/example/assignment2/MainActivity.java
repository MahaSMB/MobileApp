package com.example.assignment2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewProductType, textViewTotalPrice, textViewQuantity, tvPopUp;
    ListView listViewStore;
    int quantityEntered, selectedProductQty, newProductQty;

    ArrayList<Product> currentStock;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
            button0, buttonClear, buttonBuy, buttonManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewProductType = findViewById(R.id.textViewProductType);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        textViewQuantity = findViewById(R.id.textViewQuantity);

        listViewStore = findViewById(R.id.listView);

        currentStock = ((MyApp)getApplication()).store;

        Log.d("populated currentStock", "From MyApp.store. Size: " + currentStock.size());

        quantityEntered = Integer.parseInt(textViewQuantity.getText().toString());

        ((MyApp)getApplication()).mainActivityContext = MainActivity.this;

        ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(currentStock, this);

        listViewStore.setAdapter(productBaseAdapter);

        if (currentStock.size() < 3) {
            // Populate the store
            Product pants = new Product("Pants", 10, 20.44);
            Product shoes = new Product("Shoes", 100, 10.44);
            Product hats = new Product("Hats", 30, 5.90);
            currentStock.add(pants);
            Log.d("added to currentStock", "Product pants initial. Size: " + currentStock.size());
            currentStock.add(shoes);
            Log.d("added to currentStock", "Product shoes initial. Size: " + currentStock.size());
            currentStock.add(hats);
            Log.d("added to currentStock", "Product hats initial. Size: " + currentStock.size());
        }


        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                id = (long) parent.getId();
                quantityEntered = Integer.parseInt(textViewQuantity.getText().toString());

                if (id == R.id.listView) {

                    // Save selected Product position in MyApp before purchase
                    ((MyApp)getApplication()).positionOfProduct = (int) productBaseAdapter.getItemId(position);

                    // setting the textView to show the product name in the listView for each product
                    textViewProductType.setText(currentStock.get(position).getProductName());

                    // setting the dollar sign for the total price to show up before the total price
                    textViewTotalPrice.setText("$");

                    // setting the textView to show the product price in the listView for each product
                    textViewTotalPrice.append(String.valueOf(currentStock.get(position).getProductPrice()));

                    // calling the total price function to calculate the total price of the sale (total price = quantity * product price)
                    //noinspection StringEquality
                    if (textViewQuantity.getText().toString() == "") {
                        // Safeguarding against NumberFormatException for input string ""
                        totalPrice(0, currentStock.get(position).getProductPrice());

                    } // https://stackoverflow.com/questions/8780962/proper-way-to-avoid-parseint-throwing-a-numberformatexception-for-input-string
                    else {
                         totalPrice(Integer.parseInt(textViewQuantity.getText().toString()), currentStock.get(position).getProductPrice());

                    }

                    // Retrieving the current amount of items per item for each product left in the store
                    if ( quantityEntered > currentStock.get(position).getProductQty()) {
                        Toast.makeText(getApplicationContext(), R.string.error_onClickNotEnoughStock, Toast.LENGTH_LONG).show();
                    }
                    else {
                        selectedProductQty = currentStock.get(position).getProductQty();
                    }
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
        buttonManager = findViewById(R.id.buttonManager);

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
        buttonManager.setOnClickListener(this);
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
        else if (id == R.id.buttonBuy) {
            if (quantityEntered != 0 && textViewProductType.getText().toString() != "") {
                newProductQty = makePurchase(quantityEntered, selectedProductQty);

                // save newProductQty to MyApp and retrieve it to update
                ((MyApp)getApplication()).newProductQty = newProductQty;

                onButtonShowPopupWindowClick(view);

                // update product quantity
                currentStock.get(((MyApp)getApplication()).positionOfProduct).setProductQty(((MyApp)getApplication()).newProductQty);

                // Set purchase Date and create purchase history object
                String purchasedProductName = currentStock.get(((MyApp)getApplication()).positionOfProduct).getProductName();
                Double purchasedTotal = ((MyApp)getApplication()).totalPrice;
                Date purchaseDate = new Date();
                History productHistory = new History( purchasedProductName, quantityEntered,
                        purchasedTotal, purchaseDate);

                // To be used in RecyclerViewHistoryActivity
                ((MyApp)getApplication()).historyList.add(productHistory);

                // Save inventory (quantities of each product) for restocking purposes
//                saveInventory();

            }
            else {
                Toast.makeText(getApplicationContext(), R.string.error_missingQtyProduct, Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.buttonManager) {
            Intent toManagerIntent = new Intent(MainActivity.this, Manager.class);
            toManagerIntent.putExtra("purchaseHistory", currentStock);
            startActivity(toManagerIntent);

        }
    }

    void clearQuantity() {
        textViewQuantity.setText("0");
    }

    void totalPrice(int amount, double itemPrice) {
        double totalPrice = amount * itemPrice;
        DecimalFormat df = new DecimalFormat("0.00");
        textViewTotalPrice.setText(df.format(totalPrice));

        ((MyApp)getApplication()).totalPrice = totalPrice;
    }

    int makePurchase(int purchasedAmount, int oldQuantity) {
//        int newQuantity = oldQuantity - purchasedAmount;

        return oldQuantity - purchasedAmount;
    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        tvPopUp = popupView.findViewById(R.id.tvPopUp);

        String thankYouForPurchase = "Thank you for your purchase!\r\n" + "\nYour purchase is for " +
                quantityEntered + " " + textViewProductType.getText().toString() + " for $" +
                textViewTotalPrice.getText().toString();

        tvPopUp.setText(thankYouForPurchase);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token

        // adding a shadow
        popupWindow.setElevation(20);


        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();

                // restart activity so that new product quantities are updated after purchase
                restartActivity(MainActivity.this);

                return true;
            }
        });

        /*
                https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
         */
    }

    public void restartActivity(Activity activity) {
        Intent i = activity.getIntent();
        activity.finish();

        // Clearing arrayListOfProducts so that the listview does not create new rows when
        // the activity restarts
        //((MyApp)getApplication()).productBaseAdapter.clearArrayListOfProducts();

        activity.startActivity(i);

        /*
        https://stackoverflow.com/questions/1397361/how-to-restart-activity-in-android
        */
    }

    public void saveInventory() {

        // inventory array indices: Pants = 0, Shoes = 1, Hats = 2

        // Saving inventory after each purchase into MyApp
//        ((MyApp)getApplication()).inventory[0] = currentStock.get(0).getProductQty();
//        ((MyApp)getApplication()).inventory[1] = currentStock.get(1).getProductQty();
//        ((MyApp)getApplication()).inventory[2] = currentStock.get(2).getProductQty();

//        ((MyApp)getApplication()).store = currentStock;

    }


}