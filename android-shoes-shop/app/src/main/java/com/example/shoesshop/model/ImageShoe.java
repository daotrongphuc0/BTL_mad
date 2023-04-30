package com.example.shoesshop.model;

public class ImageShoe {
    private String image,shoeId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShoeId() {
        return shoeId;
    }

    public void setShoeId(String shoeId) {
        this.shoeId = shoeId;
    }

    public ImageShoe(String image, String shoeId) {
        this.image = image;
        this.shoeId = shoeId;
    }
}
