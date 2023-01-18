package com.store.productsservice.domain;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Products")
@Builder
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double price;

    private String description;

    private Integer stock;

    private Date creationDate;

    private Date updateDate;


    public Product() {}

    /*
    @PrePersist
    private void prePersistProduct(){
        if(this.id == null || this.id.isEmpty()){
            log.info("ID GENERATED");
            this.id= UUID.randomUUID().toString();
        }
    }
*/
    @PreUpdate
    private void preUpdateProduct(){
        this.updateDate = new Date();
    }

    public Product(Integer id, String name, double price, String description, Integer stock, Date creationDate
            ,Date updateDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
