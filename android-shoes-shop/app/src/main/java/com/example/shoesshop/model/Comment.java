package com.example.shoesshop.model;

public class Comment {
    private float rate;
    private String content,createAt,shoeId,userId;

    public Comment(float rate, String content, String createAt, String shoeId, String userId) {
        this.rate = rate;
        this.content = content;
        this.createAt = createAt;
        this.shoeId = shoeId;
        this.userId = userId;
    }
    public Comment(){

    }
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getShoeId() {
        return shoeId;
    }

    public void setShoeId(String shoeId) {
        this.shoeId = shoeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
