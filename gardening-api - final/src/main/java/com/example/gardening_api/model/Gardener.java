package com.example.gardening_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "gardeners")
public class Gardener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String experienceLevel;

    @OneToMany(mappedBy = "gardener", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Gardener() {
    }

    public Gardener(String name, String phoneNumber, String experienceLevel) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experienceLevel = experienceLevel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
