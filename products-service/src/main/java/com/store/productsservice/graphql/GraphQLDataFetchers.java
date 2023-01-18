package com.store.productsservice.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.productsservice.domain.Feature;
import com.store.productsservice.domain.Product;
import com.store.productsservice.graphql.objects.inputs.ProductInput;
import com.store.productsservice.service.FeatureService;
import com.store.productsservice.service.ProductService;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GraphQLDataFetchers {

    @Autowired
    private ProductService productService;

    @Autowired
    private FeatureService featureService;
    public DataFetcher<List<Product>> getFindAllDataFetcher() {
        return dataFetchingEnvironment -> productService.findAllProducts();
    }

    public DataFetcher<Product> getAddProductDataFetcher() {
        return dataFetchingEnvironment -> {
            ProductInput productInput = new ObjectMapper()
                    .convertValue(dataFetchingEnvironment.getArgument("productInput"),ProductInput.class) ;

            Product productSaved= productService.createProduct(productInput);
            log.info("PRODUCT CREATED : " + productSaved.getId());
            return productSaved;
        };
    }

    public DataFetcher<Product> getUpdateProductDataFetcher(){
        return dataFetchingEnvironment -> {
            ProductInput productInput = new ObjectMapper()
                    .convertValue(dataFetchingEnvironment.getArgument("productInput"),ProductInput.class);

            Product productUpdated = productService.updateProduct(dataFetchingEnvironment.getArgument("id"),productInput);
            if(productUpdated != null){
                log.info("PRODUCT UPDATED : "+productUpdated.getId());
            }else {
                log.error("PRODUCT NOT FOUND");
            }
            return productUpdated;
        };
    }

    public DataFetcher<Product> getDeleteProductDataFetcher(){
        return dataFetchingEnvironment -> {
            productService.deleteProduct(dataFetchingEnvironment.getArgument("id"));
            return null;
        };
    }

    public DataFetcher<List<Feature>> getFeaturesByProduct(){
        return dataFetchingEnvironment -> featureService.getFeaturesByProduct(dataFetchingEnvironment.getArgument("id"));

    }

}
