package br.org.iredeam.data.dtos;

import br.org.iredeam.data.commons.GenericDto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDto extends GenericDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Date expirationDate;
    private CategoryDto category;


    public ProductDto() {
        super();
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
