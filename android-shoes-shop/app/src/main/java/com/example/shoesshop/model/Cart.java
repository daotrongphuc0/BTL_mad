package com.example.shoesshop.model;

public class Cart {
    private int quantity;
    private String userId,detailShoeId;

    public Cart(int quantity, String userId, String detailShoeId) {
        this.quantity = quantity;
        this.userId = userId;
        this.detailShoeId = detailShoeId;
    }
    public Cart(){

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetailShoeId() {
        return detailShoeId;
    }

    public void setDetailShoeId(String detailShoeId) {
        this.detailShoeId = detailShoeId;
    }
}
