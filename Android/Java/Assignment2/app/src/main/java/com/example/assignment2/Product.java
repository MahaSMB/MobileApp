package com.example.assignment2;

public class Product {

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
