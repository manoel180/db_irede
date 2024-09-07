package br.org.iredeam.domain.entities;

import br.org.iredeam.domain.common.BusinessObjectDomain;

import java.util.Date;

public class Image extends BusinessObjectDomain {
    private Product product;
    private String name;
    private byte[] image;

    public Image() {
    }

    public Image(Long entityId, Date creation, Boolean active, Product product, String name, byte[] image) {
        super(entityId, creation, active);
        this.product = product;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
