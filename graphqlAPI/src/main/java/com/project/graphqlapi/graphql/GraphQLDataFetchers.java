package com.project.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GraphQLDataFetchers {
    //Clase encargada de tomar los datos y hacer las consultas

    private List<User> users = Arrays.asList(new User(1, "Mitchell", "Hudson", "mitchell.hudson11@example.com"),
            new User(2, "Melanie", "Bell", "melanie.bell51@example.com"),
            new User(3, "Diane", "Ruiz", "diane.ruiz24@example.com"));

    public DataFetcher<List<User>> getFindAllDataFetcher() {
        return dataFetchingEnvironment -> this.users;
    }

}
//Inner class
class User{
    private Integer id;
    private String name;
    private String surname;
    private String email;

    public User(Integer id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}