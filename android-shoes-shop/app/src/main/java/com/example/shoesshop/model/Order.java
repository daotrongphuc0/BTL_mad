package com.example.shoesshop.model;

public class Order {
    private int quantity;
    private String userId,detailShoeId,billId;
    private float price;

    public Order() {
    }

    public Order(int quantity, String userId, String detailShoeId, float price,String billId) {
        this.quantity = quantity;
        this.userId = userId;
        this.detailShoeId = detailShoeId;
        this.price = price;
        this.billId = billId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
