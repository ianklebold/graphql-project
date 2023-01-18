package com.store.productsservice.mappers;

import com.store.productsservice.domain.Product;
import com.store.productsservice.graphql.objects.ProductObject;
import com.store.productsservice.graphql.objects.inputs.ProductInput;

import java.util.Date;

public class ProductMapper {

    public static ProductObject productToProductObject(Product product){
        return ProductObject.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .creationDate(product.getCreationDate().toString())
                    .price(String.valueOf(product.getPrice()))
                    .stock(product.getStock()).build();
    }

    public static Product productInputToProduct(ProductInput productInput){
        return Product.builder()
                .name(productInput.getName())
                .description(productInput.getDescription())
                .price(Double.parseDouble(productInput.getPrice()))
                .stock(productInput.getStock())
                .creationDate(new Date())
                .updateDate(null)
                .build();
    }


    public static Product updateProduct(Product product,ProductInput productInput){
        product.setName(productInput.getName());
        product.setDescription(productInput.getDescription());
        product.setPrice(Double.parseDouble(productInput.getPrice()));
        product.setStock(productInput.getStock());
        return product;
    }
}
