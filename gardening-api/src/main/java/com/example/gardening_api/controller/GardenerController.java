package com.example.gardening_api.controller;

import com.example.gardening_api.model.Gardener;
import com.example.gardening_api.service.GardenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gardeners") 
public class GardenerController {

    @Autowired
    private GardenerService gardenerService;

    
    @GetMapping
    public List<Gardener> getAllGardeners() {
        return gardenerService.getAllGardeners();
    }

    
    @GetMapping("/{id}")
    public Optional<Gardener> getGardenerById(@PathVariable Long id) {
        return gardenerService.getGardenerById(id);
    }

    
    @PostMapping
    public Gardener createGardener(@RequestBody Gardener gardener) {
        return gardenerService.saveGardener(gardener);
    }

    
    @PutMapping("/{id}")
    public Gardener updateGardener(@PathVariable Long id, @RequestBody Gardener updatedGardener) {
        return gardenerService.updateGardener(id, updatedGardener);
    }

    
    @DeleteMapping("/{id}")
    public void deleteGardener(@PathVariable Long id) {
        gardenerService.deleteGardener(id);
    }
}
