package com.example.assignment2;

import java.io.Serializable;
import java.util.Date;

public class History extends Product implements Serializable {

    Date purchaseDate;

    public History(String productName, int productQty, double productPrice, Date purchaseDate) {
        super(productName, productQty, productPrice);
        this.purchaseDate = purchaseDate;
    }

    public History () {

    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
