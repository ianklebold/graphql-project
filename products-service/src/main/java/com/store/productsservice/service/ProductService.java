package com.store.productsservice.service;

import com.store.productsservice.domain.Product;
import com.store.productsservice.graphql.objects.inputs.ProductInput;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product createProduct(ProductInput productInput);
    Product updateProduct(Integer id,ProductInput productInput);
    void deleteProduct(Integer id);
}
