package com.example.ProductService.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Productsid")
    private Long id;

    private String productCode;

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    @Column(name = "Name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Quantity")
    private int quantity;

    public Product() {
    }

    public Product(Long id, String productCode, String name, String category, Double price,int quantity) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
