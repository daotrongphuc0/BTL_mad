package com.example.shoesshop.model;

public class User {

    private int id;

    private String email;
    private String sdt;
    private String hoVaTen;
    private String password;
    private String id_phan_quyen;


    public User(int id, String email, String sdt, String hoVaTen, String password, String id_phan_quyen) {
        this.id = id;
        this.email = email;
        this.sdt = sdt;
        this.hoVaTen = hoVaTen;
        this.password = password;
        this.id_phan_quyen = id_phan_quyen;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_phan_quyen() {
        return id_phan_quyen;
    }

    public void setId_phan_quyen(String id_phan_quyen) {
        this.id_phan_quyen = id_phan_quyen;
    }
}
