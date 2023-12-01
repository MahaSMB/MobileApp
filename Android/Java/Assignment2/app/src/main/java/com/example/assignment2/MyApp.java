package com.example.assignment2;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class MyApp extends Application {
    ArrayList<Product> store = new ArrayList<>();

    ArrayList<History> historyList = new ArrayList<>();

    int[] inventory = new int[3]; // inventory array indices: Pants = 0, Shoes = 1, Hats = 2
    Double totalPrice;

    Context mainActivityContext;
//    ListView listViewStore;
//    ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(store, mainActivityContext);

    int newProductQty;

    int positionOfProduct;

//    ArrayList<Product> arrayListOfProducts = new ArrayList<>();

}
