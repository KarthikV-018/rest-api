package com.example.gardening_api.service.impl;

import com.example.gardening_api.model.Gardener;
import com.example.gardening_api.repository.GardenerRepository;
import com.example.gardening_api.service.GardenerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GardenerServiceImpl implements GardenerService {

    @Autowired
    private GardenerRepository gardenerRepository;

    @Override
    public Gardener saveGardener(Gardener gardener) {
        return gardenerRepository.save(gardener);
    }

    @Override
    public Optional<Gardener> getGardenerById(Long id) {
        return gardenerRepository.findById(id);
    }

    @Override
    public List<Gardener> getAllGardeners() {
        return gardenerRepository.findAll();
    }

    @Override
    public Gardener updateGardener(Long id, Gardener updatedGardener) {
        Optional<Gardener> existingGardener = gardenerRepository.findById(id);
        if (existingGardener.isPresent()) {
            Gardener gardener = existingGardener.get();
            gardener.setName(updatedGardener.getName());
            gardener.setPhoneNumber(updatedGardener.getPhoneNumber());
            gardener.setExperienceLevel(updatedGardener.getExperienceLevel());
            return gardenerRepository.save(gardener);
        } else {
            throw new RuntimeException("Gardener not found with ID: " + id);
        }
    }

    @Override
    public void deleteGardener(Long id) {
        gardenerRepository.deleteById(id);
    }
}
