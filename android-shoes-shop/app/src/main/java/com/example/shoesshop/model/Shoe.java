package com.example.shoesshop.model;

public class Shoe {
    private String name,status,brandId;
    private float price,discountPrice,averageRate;
    private int soldNumber;

    public Shoe(String name, String status, String brandId, float price, float discountPrice, float averageRate, int soldNumber) {
        this.name = name;
        this.status = status;
        this.brandId = brandId;
        this.price = price;
        this.discountPrice = discountPrice;
        this.averageRate = averageRate;
        this.soldNumber = soldNumber;
    }
    public Shoe(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(float averageRate) {
        this.averageRate = averageRate;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }
}
