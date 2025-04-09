package com.example.gardening_api.service;

import com.example.gardening_api.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();  
    Page<Product> getProducts(int page, int size, String sort); 
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
