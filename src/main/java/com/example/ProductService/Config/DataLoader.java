package com.example.ProductService.Config;

import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository) {

        return args -> {

            productRepository.deleteAll();
            productRepository.save(new Product(null, "S1230", "Face Wash", "SkinCare", 70.99, 10));
            productRepository.save(new Product(null, "H1001", "Hair Shampoo and Conditioner", "HairProducts", 30.00, 25));
            productRepository.save(new Product(null, "A2345","Women HandBag", "WomenAccessories", 120.00, 15));
            productRepository.save(new Product(null, "D2901","Summer Short Dress", "WomenDress", 50.00, 10));
            productRepository.save(new Product(null, "E2109","Colossal Kajal", "EyeCare", 15.70, 20));

        };
    }
}
