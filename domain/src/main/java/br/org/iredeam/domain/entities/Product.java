package br.org.iredeam.domain.entities;


import br.org.iredeam.domain.common.BusinessObjectDomain;

import java.math.BigDecimal;
import java.util.Date;


public class Product extends BusinessObjectDomain {

    private String name;
    private String description;
    private BigDecimal price;
    private Date expirationDate;
    private Category category;

    public Product() {
    }

    public Product(Long entityId, Date creation, Boolean active,
                   String name,
                   String description, BigDecimal price, Date expirationDate, Category category) {
        super(entityId, creation, active);
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.category = category;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
