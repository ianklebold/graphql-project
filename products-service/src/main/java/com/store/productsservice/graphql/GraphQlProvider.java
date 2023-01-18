package com.store.productsservice.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import graphql.schema.idl.errors.SchemaProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GraphQlProvider {
    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Value("classpath:product.graphql")
    private Resource resource;

    private GraphQL graphQL;

    private final static String MUTATION = "Mutation";

    private final static String QUERY = "Query";

    @PostConstruct
    public void init() throws SchemaProblem, IOException {
        final GraphQLSchema graphQLSchema = this.buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() throws SchemaProblem, IOException {
        final TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(this.resource.getInputStream());
        final SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeRegistry, this.buildWiring());
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring(QUERY).dataFetcher("findAllProducts",
                        this.graphQLDataFetchers.getFindAllDataFetcher()))
                .type(TypeRuntimeWiring.newTypeWiring(QUERY).dataFetcher("findAllFeaturesByProduct",
                        this.graphQLDataFetchers.getFeaturesByProduct()))
                .type(TypeRuntimeWiring.newTypeWiring(MUTATION).dataFetcher("addProduct",
                        this.graphQLDataFetchers.getAddProductDataFetcher()))
                .type(TypeRuntimeWiring.newTypeWiring(MUTATION).dataFetcher("updateProduct",
                        this.graphQLDataFetchers.getUpdateProductDataFetcher()))
                .type(TypeRuntimeWiring.newTypeWiring(MUTATION).dataFetcher("deleteProduct",
                        this.graphQLDataFetchers.getDeleteProductDataFetcher()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }
}
