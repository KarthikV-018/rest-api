package com.example.gardening_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gardeners")
public class Gardener {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String experienceLevel;

    public Gardener() {}

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
}
