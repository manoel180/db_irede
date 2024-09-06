package br.org.iredeam.data.dtos;

import br.org.iredeam.data.commons.GenericDto;
import br.org.iredeam.domain.entities.Product;

public class ImageDto extends GenericDto {
    private String name;
    private Product product;
    private byte[] image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
