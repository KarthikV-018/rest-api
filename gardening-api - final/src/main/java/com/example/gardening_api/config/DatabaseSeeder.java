package com.example.gardening_api.config;

import com.example.gardening_api.model.Product;
import com.example.gardening_api.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DatabaseSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        try {
            long count = productRepository.count();
            if (count == 0) {
                Random random = new Random();
                for (int i = 1; i <= 100; i++) {
                    Product product = new Product(
                            "Product " + i,
                            "Description for product " + i,
                            10 + random.nextDouble() * 90,  
                            random.nextInt(100) + 1       
                    );
                    productRepository.save(product);
                }
                System.out.println("✅ 100 Products Added Successfully!");
            } else {
                System.out.println("✅ Products Already Exist. Skipping Seeding.");
            }
        } catch (Exception e) {
            System.err.println("❌ Error seeding products: " + e.getMessage());
        }
    }
}
