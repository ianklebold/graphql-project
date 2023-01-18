package com.store.productsservice.service.impl;

import com.store.productsservice.domain.Product;
import com.store.productsservice.graphql.objects.inputs.ProductInput;
import com.store.productsservice.mappers.ProductMapper;
import com.store.productsservice.repository.ProductRepository;
import com.store.productsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductInput productInput) {
        return productRepository.save(ProductMapper.productInputToProduct(productInput));
    }

    @Override
    public Product updateProduct(Integer id, ProductInput productInput) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productRepository.save(ProductMapper.updateProduct(product.get(), productInput));
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            productRepository.delete(product.get());
        }
    }
}
