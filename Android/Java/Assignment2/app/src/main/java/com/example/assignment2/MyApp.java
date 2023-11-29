package com.example.assignment2;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class MyApp extends Application {
    ArrayList<Product> store = new ArrayList<>();

    ArrayList<History> historyList = new ArrayList<>();
    Double totalPrice;

    Context mainActivityContext;
//    ListView listViewStore;
//    ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(store, mainActivityContext);

    int newProductQty;

    int positionOfProduct;

//    ArrayList<Product> arrayListOfProducts = new ArrayList<>();

}
