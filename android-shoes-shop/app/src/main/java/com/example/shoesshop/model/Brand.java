package com.example.shoesshop.model;

public class Brand {
    private String name, iconImage;

    public Brand(String name, String iconImage) {
        this.name = name;
        this.iconImage = iconImage;
    }
    public Brand(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }
}
