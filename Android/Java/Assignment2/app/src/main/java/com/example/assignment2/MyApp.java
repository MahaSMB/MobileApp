package com.example.assignment2;

import android.app.Application;
import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;

public class MyApp extends Application {
    ArrayList<Product> store = new ArrayList<>();
    Context mainActivityContext;
    ListView listViewStore;
    ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(store, mainActivityContext);

    int newProductQty;

    int positionOfProduct;

    ArrayList<Product> arrayListOfProducts = new ArrayList<>();

}
