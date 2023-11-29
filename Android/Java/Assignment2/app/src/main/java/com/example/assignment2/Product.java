package com.example.assignment2;

import java.io.Serializable;

public class Product implements Serializable {

    String productName;
    int productQty;
    double productPrice;

    public Product(String productName, int productQty, double productPrice) {
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQty() {
        return productQty;
    }

    public double getProductPrice() {
        return productPrice;
    }



}
