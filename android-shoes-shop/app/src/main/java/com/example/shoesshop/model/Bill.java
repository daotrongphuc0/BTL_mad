package com.example.shoesshop.model;

public class Bill {
    private String deliveryAddress,status,createAt,userId;
    private float sumPrice;
    public Bill(){

    }
    public Bill(String deliveryAddress, String status, String createAt, String userId, float sumPrice) {
        this.deliveryAddress = deliveryAddress;
        this.status = status;
        this.createAt = createAt;
        this.userId = userId;
        this.sumPrice = sumPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }
}
