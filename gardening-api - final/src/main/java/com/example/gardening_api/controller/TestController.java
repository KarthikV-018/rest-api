package com.example.gardening_api.controller;

import com.example.gardening_api.model.*;
import com.example.gardening_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private GardenerRepository gardenerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Test Gardener-Order relationship
    @PostMapping("/gardener-order")
    public ResponseEntity<String> testGardenerOrderRelationship() {
        // Create a gardener
        Gardener gardener = new Gardener("Test Gardener", "1234567890", "Expert");
        gardener = gardenerRepository.save(gardener);

        // Create an order
        Order order = new Order("Test Customer", "Landscaping", "Pending");
        order.setGardener(gardener);
        order = orderRepository.save(order);

        // Verify the relationship
        List<Order> gardenerOrders = gardener.getOrders();
        return ResponseEntity.ok("Gardener-Order relationship test completed. Gardener has " +
                gardenerOrders.size() + " orders");
    }

    // Test User-Order relationship
    @PostMapping("/user-order")
    public ResponseEntity<String> testUserOrderRelationship() {
        // Create a user
        User user = new User("testuser", "test@example.com", "password", "CUSTOMER");
        user = userRepository.save(user);

        // Create an order
        Order order = new Order("Test Customer", "Maintenance", "Pending");
        order.setUser(user);
        order = orderRepository.save(order);

        // Verify the relationship
        List<Order> userOrders = user.getOrders();
        return ResponseEntity.ok("User-Order relationship test completed. User has " +
                userOrders.size() + " orders");
    }

    // Test Order-Product relationship
    @PostMapping("/order-product")
    public ResponseEntity<String> testOrderProductRelationship() {
        // Create an order
        Order order = new Order("Test Customer", "Planting", "Pending");
        order = orderRepository.save(order);

        // Create products
        Product product1 = new Product("Rose Plant", "Beautiful red rose", 19.99, 10);
        Product product2 = new Product("Tulip Bulbs", "Spring tulip bulbs", 9.99, 50);

        product1.setOrder(order);
        product2.setOrder(order);

        productRepository.save(product1);
        productRepository.save(product2);

        // Verify the relationship
        List<Product> orderProducts = order.getProducts();
        return ResponseEntity.ok("Order-Product relationship test completed. Order has " +
                orderProducts.size() + " products");
    }

    // Test complete relationship chain
    @PostMapping("/complete-chain")
    public ResponseEntity<String> testCompleteRelationshipChain() {
        // Create a gardener
        Gardener gardener = new Gardener("Chain Gardener", "9876543210", "Expert");
        gardener = gardenerRepository.save(gardener);

        // Create a user
        User user = new User("chainuser", "chain@example.com", "password", "CUSTOMER");
        user = userRepository.save(user);

        // Create an order
        Order order = new Order("Chain Customer", "Full Service", "Pending");
        order.setGardener(gardener);
        order.setUser(user);
        order = orderRepository.save(order);

        // Create products
        Product product1 = new Product("Garden Tools", "Complete tool set", 49.99, 5);
        Product product2 = new Product("Fertilizer", "Organic fertilizer", 29.99, 20);

        product1.setOrder(order);
        product2.setOrder(order);

        productRepository.save(product1);
        productRepository.save(product2);

        return ResponseEntity.ok("Complete relationship chain test completed successfully");
    }
}