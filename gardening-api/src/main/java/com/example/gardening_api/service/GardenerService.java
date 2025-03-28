package com.example.gardening_api.service;

import com.example.gardening_api.model.Gardener;
import java.util.List;
import java.util.Optional;

public interface GardenerService {
    Gardener saveGardener(Gardener gardener);
    Optional<Gardener> getGardenerById(Long id);
    List<Gardener> getAllGardeners();
    Gardener updateGardener(Long id, Gardener updatedGardener); 
    void deleteGardener(Long id);
}
