package com.example.shoesshop.model;

public class DetailShoe {
    private String color, status,shoeId;
    private int size, inventory;

    public DetailShoe(String color, String status, String shoeId, int size, int inventory) {
        this.color = color;
        this.status = status;
        this.shoeId = shoeId;
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

    public String getShoeId() {
        return shoeId;
    }

    public void setShoeId(String shoeId) {
        this.shoeId = shoeId;
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
