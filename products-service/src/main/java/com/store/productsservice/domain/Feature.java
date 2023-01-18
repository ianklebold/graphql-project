package com.store.productsservice.domain;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Features")
@Builder
public class Feature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Date creationDate;

    private Date updateDate;

    private Integer productId;

    @PreUpdate
    private void preUpdateProduct(){
        this.updateDate = new Date();
    }

    public Feature() {
    }

    public Feature(Integer id, String name, String description, Date creationDate, Date updateDate, Integer productId) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.productId = productId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
