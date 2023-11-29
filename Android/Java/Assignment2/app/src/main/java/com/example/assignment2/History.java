package com.example.assignment2;

import java.io.Serializable;
import java.util.Date;

public class History extends Product implements Serializable {

    Date purchaseDate;

    public History(Date purchaseDate) {
        super();
        this.purchaseDate = purchaseDate;
    }

    public History(Product product, Date purchaseDate) {
        super(product.getProductName(), product.getProductQty(), product.getProductPrice());
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
}
