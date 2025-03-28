package com.example.gardening_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")  
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerName;
    private String serviceType;
    private String status;

    
    public Order() {}

    public Order(String customerName, String serviceType, String status) {
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.status = status;
    }

    
    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getStatus() {
        return status;
    }

    
    public void setId(Long id) { 
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
