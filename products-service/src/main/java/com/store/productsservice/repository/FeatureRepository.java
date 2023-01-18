package com.store.productsservice.repository;

import com.store.productsservice.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature,Integer> {
    List<Feature> findFeatureByProductId(Integer id);
}
