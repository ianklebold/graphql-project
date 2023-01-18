package com.store.productsservice.service;

import com.store.productsservice.domain.Feature;

import java.util.List;

public interface FeatureService {
    List<Feature> getFeaturesByProduct(Integer idProduct);
}
