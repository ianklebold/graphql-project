package com.store.productsservice.service.impl;

import com.store.productsservice.domain.Feature;
import com.store.productsservice.repository.FeatureRepository;
import com.store.productsservice.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public List<Feature> getFeaturesByProduct(Integer idProduct) {
        return featureRepository.findFeatureByProductId(idProduct);
    }
}
