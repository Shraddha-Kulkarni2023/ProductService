package com.example.ProductService.Model;

public class Inventory {

    private String productCode;
    private int quantity;

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }
}
