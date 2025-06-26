package com.example.ProductService.Controller;

import com.example.ProductService.Model.Product;
import com.example.ProductService.Service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {

    private Logger logger;
    @Autowired
    public ProductService productService;

    @GetMapping("/start")
    public String start() {

        return "Product service started";
    }

    @GetMapping("/get_products")
    public List<Product> getAll() {

        return productService.getAllProducts();
    }



    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {

        return productService.getProductByCategory(category);
    }

    @PostMapping("/add_products")
    public Product addProducts(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @DeleteMapping("/delete_product/{name}")
    public ResponseEntity<String> deleteProductByName(@PathVariable String name) {
        System.out.println("Received request to delete: " + name);
        String result = productService.updateorDeleteByProductName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test/{name}")
    public String testPath(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping("/total")
    public Integer getTotalQuantity() {

        return productService.getTotalProductQuantity();
    }

    @GetMapping("/productgreaterthan/{price}")
    public List<Product> getProductGreaterThan(@PathVariable Double price) {

        return productService.getProductGreaterThan(price);
    }

    @GetMapping("/productlessthan/{price}")
    public List<Product> getProductLessThan(@PathVariable Double price) {

        return productService.getProductLessThan(price);
    }

    @GetMapping("/productbetween/{minprice}/{maxprice}")
    public List<Product> getProductBetween(@PathVariable Double minprice, @PathVariable Double maxprice) {
        return productService.getProductBetween(minprice,maxprice);

    }

    @GetMapping("/check-stock")
    public ResponseEntity<String> checkStock(@RequestParam String productCode, @RequestParam int quantity) {

        boolean available = productService.isProductInStock(productCode,quantity);
        if(available) {
            return ResponseEntity.ok("Product is in stock");

        } else {

            return ResponseEntity.ok("Product is not in stock");
        }
    }




}
