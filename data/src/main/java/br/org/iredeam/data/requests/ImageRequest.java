package br.org.iredeam.data.requests;

public class ImageRequest {
    public String name;
    private Long product;
    private byte[] image;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
