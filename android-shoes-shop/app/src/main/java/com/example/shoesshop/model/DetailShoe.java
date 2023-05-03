package com.example.shoesshop.model;

public class DetailShoe {
    private String color, status,cartId;
    private Shoe shoe;

    private int size, inventory;

    public DetailShoe(String color, String status, String cartId, Shoe shoe, int size, int inventory) {
        this.color = color;
        this.status = status;
        this.cartId = cartId;
        this.shoe = shoe;
        this.size = size;
        this.inventory = inventory;
    }
    public DetailShoe(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
