package com.example.shoesshop.model;

public class Cart {
    private int quantity;
    private User user;
    private DetailShoe detailShoe;

    public Cart(int quantity, User user, DetailShoe detailShoe) {
        this.quantity = quantity;
        this.user = user;
        this.detailShoe = detailShoe;
    }
    public Cart(){

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DetailShoe getDetailShoe() {
        return detailShoe;
    }

    public void setDetailShoe(DetailShoe detailShoe) {
        this.detailShoe = detailShoe;
    }
}
