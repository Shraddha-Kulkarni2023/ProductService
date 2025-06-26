package com.example.ProductService.Repository;

import com.example.ProductService.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBycategory(String category);
    Optional<Product> findByName(String name);

    @Query("SELECT SUM(p.quantity) FROM Product p")
    Integer getTotalQuantity();

    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByPriceLessThan(Double price);
    List<Product> findByPriceBetween(Double min, Double max);

    List<Product> findByProductCode(String productCode);








}

