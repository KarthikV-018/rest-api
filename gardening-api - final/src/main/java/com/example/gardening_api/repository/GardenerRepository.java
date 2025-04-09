package com.example.gardening_api.repository;

import com.example.gardening_api.model.Gardener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}
