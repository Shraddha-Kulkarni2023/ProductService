package com.example.ProductService.Service;

import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(String category) {

        return productRepository.findBycategory(category);
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    public String updateorDeleteByProductName(String name) {

        Optional<Product> optionalProduct = productRepository.findByName(name);

        if(optionalProduct.isPresent()) {

            Product product = optionalProduct.get();

            if(product.getQuantity() <= 1) {

                productRepository.delete(product);
                return "Product deleted as quantity was 0 or 1";
            } else {

                product.setQuantity(product.getQuantity() - 1);
                productRepository.save(product);
                return "Quantity decreased by 1";
            }
        } else {

            return "Product not found";
        }
    }

    public Integer getTotalProductQuantity() {

        return productRepository.getTotalQuantity();
    }

    public List<Product> getProductGreaterThan(Double price) {

        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> getProductLessThan(Double price) {

        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> getProductBetween(Double minprice, Double maxprice) {

        return productRepository.findByPriceBetween(minprice,maxprice);
    }

    public boolean isProductInStock(String productCode,int quantity) {

        String url = "http://localhost:8083/inventory/check?productCode=" + productCode + "&quantity=" + quantity;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url,Boolean.class);
        return Boolean.TRUE.equals(response.getBody());
    }

    public List<Product> findByProductCode(String productCode) {

        return productRepository.findByProductCode(productCode);
    }

}
